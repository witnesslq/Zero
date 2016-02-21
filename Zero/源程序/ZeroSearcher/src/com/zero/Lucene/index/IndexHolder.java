package com.zero.Lucene.index;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.MultiReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TotalHitCountCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.zero.domainModel.Searchable;

/**
 * ���������
 * @author Winter Lau
 */
public class IndexHolder {
	//�ñ����class�õ�һ����־��ʵ����������ȡ��Ϊ�˵õ�ͬһ����־������
    private final static Log log = LogFactory.getLog(IndexHolder.class);
    //���ķִ���������ʵ��
    private final static IKAnalyzer analyzer = new IKAnalyzer();
    private final static int MAX_COUNT = 1000;
    //������ַ
	private String indexPath;

	/**
	 * �������������ʵ��
	 * @param idx_path
	 * @return
	 * @throws IOException
	 */
	public static IndexHolder init(String idx_path) throws IOException {
		IndexHolder holder = new IndexHolder();
		idx_path = FilenameUtils.normalize(idx_path);//���ļ���ַ������
		File file = new File(idx_path);
		if(!file.exists() || !file.isDirectory())
			throw new FileNotFoundException(idx_path);//�ļ�������ʱ,���߲��Ǹ��ļ��������,�׳��쳣
		if(!idx_path.endsWith(File.separator))
			idx_path += File.separator;		
		holder.indexPath = idx_path;
		
		return holder;
	}
	
	/**
	 * <b> ���ݿ���������õ�һ��IndexWriter</b>
	 * @param objClass ����������
	 * @return IndexWriter ����������ַ·����װ��lucene��
	 * @throws IOException ����·��������ʱ�׳��쳣���ȴ�����
	 */
	private IndexWriter getWriter(Class<? extends Searchable> objClass) throws IOException {
		Directory dir = FSDirectory.open(new File(indexPath + objClass.getSimpleName()));
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);
	    config.setOpenMode(OpenMode.CREATE_OR_APPEND);
		return new IndexWriter(dir, config);
	}
	
	/**
	 * <b>�õ�׼ȷ��������ַ</b>
	 * @param objClass ����������
	 * @return IndexSearcher ������ַ·����װ��lucene��
	 * @throws IOException ����·��������ʱ�׳��쳣���ȴ�����
	 */
	private IndexSearcher getSearcher(Class<? extends Searchable> objClass) throws IOException{
		Directory dir = FSDirectory.open(new File(indexPath + objClass.getSimpleName()));
		return new IndexSearcher(DirectoryReader.open(dir));
	}
	
	/**
	 * <b>������Ͽ������</b>
	 * @param objClasses ����������
	 * @return IndexSearcher ������ַ·����װ��lucene��
	 * @throws IOException ����·��������ʱ�׳��쳣���ȴ�����
	 */
	private IndexSearcher getSearchers(List<Class<? extends Searchable>> objClasses) throws IOException {
		IndexReader[] readers = new IndexReader[objClasses.size()];
		int idx = 0;
		for(Class<? extends Searchable> objClass : objClasses){
			FSDirectory dir = FSDirectory.open(new File(indexPath + objClass.getSimpleName()));
			readers[idx++] = DirectoryReader.open(dir);
		}
		return new IndexSearcher(new MultiReader(readers, true));
	}

	/**
	 * �Ż�������
	 * @param objClass 
	 * @throws IOException
	 */
	public void optimize(Class<? extends Searchable> objClass) throws IOException {
		IndexWriter writer = getWriter(objClass);
		try{
			writer.forceMerge(1);
			writer.commit();
		}finally{
			writer.close();
			writer = null;
		}
	}
	
	/**
	 * �������
	 * @param objClasses
	 * @param query
	 * @param filter
	 * @param sort
	 * @param page
	 * @param count
	 * @return
	 * @throws IOException
	 */
	public List<Searchable> find(List<Class<? extends Searchable>> objClasses, Query query, Filter filter, Sort sort, int page, int count) throws IOException {
		IndexSearcher searcher = getSearchers(objClasses);
		return find(searcher, query, filter, sort, page, count);
	}
	
	/**
	 * ��������
	 * @param objClass
	 * @param query
	 * @param filter
	 * @param sort
	 * @param page
	 * @param count
	 * @return
	 * @throws IOException
	 */
	public List<Searchable> find(Class<? extends Searchable> objClass, Query query, Filter filter, Sort sort, int page, int count) throws IOException {
		IndexSearcher searcher = getSearcher(objClass);
		List<Searchable> results = find(searcher, query, filter, sort, page, count);
//		List<Long> ids = new ArrayList<Long>();
//		for(Searchable obj : results){
//			if(obj != null)
//				ids.add(obj.id());		
//		}
		return results;
	}

	/**
	 * �������
	 * @param objClasses
	 * @param query
	 * @param filter
	 * @return
	 * @throws IOException
	 */
	public int count(List<Class<? extends Searchable>> objClasses, Query query, Filter filter) throws IOException {
		IndexSearcher searcher = getSearchers(objClasses);
		return count(searcher, query, filter);
	}
	
	/**
	 * ����
	 * @param beanClass
	 * @param query
	 * @param filter
	 * @return
	 * @throws IOException
	 */
	public int count(Class<? extends Searchable> objClass, Query query, Filter filter) throws IOException {
		IndexSearcher searcher = getSearcher(objClass);
		return count(searcher, query, filter);
	}

	/**
	 * ����
	 * @param searcher
	 * @param query
	 * @param filter
	 * @param sort
	 * @param page
	 * @param count
	 * @return
	 * @throws IOException
	 */
	private List<Searchable> find(IndexSearcher searcher, Query query, Filter filter, Sort sort, int page, int count) throws IOException {
		try{
			TopDocs hits = null;
			if(filter != null && sort != null)
				hits = searcher.search(query, filter, MAX_COUNT, sort);
			else if(filter != null)
				hits = searcher.search(query, filter, MAX_COUNT);
			else if(sort != null)
				hits = searcher.search(query, MAX_COUNT, sort);
			else
				hits = searcher.search(query, MAX_COUNT);
			if(hits==null) return null;
			List<Searchable> results = new ArrayList<Searchable>();
			int nBegin = (page - 1) * count;
			int nEnd = Math.min(nBegin + count, hits.scoreDocs.length);
			for (int i = nBegin; i < nEnd; i++){
				ScoreDoc s_doc = (ScoreDoc)hits.scoreDocs[i];
				Document doc = searcher.doc(s_doc.doc);
				Searchable obj = SearchHelper.doc2obj(doc);
				if(obj != null && !results.contains(obj)){
					results.add(obj);	
				}
			}
			return results;
			
		}catch(IOException e){
			log.error("Unabled to find via query: " + query, e);
		}
		return null;
	}

	/**
	 * ���ݲ�ѯ����ͳ�����������
	 * @param searcher
	 * @param query
	 * @param filter
	 * @return
	 * @throws IOException
	 */
	private int count(IndexSearcher searcher, Query query, Filter filter) throws IOException {
		try{
			TotalHitCountCollector thcc = new TotalHitCountCollector();
			if(filter != null)
				searcher.search(query,filter,thcc);
			else
				searcher.search(query,thcc);
			return Math.min(MAX_COUNT, thcc.getTotalHits());
		}catch(IOException e){
			log.error("Unabled to find via query: " + query, e);
			return -1;
		}
	}
	
	/**
	 * �����������
	 * @param docs
	 * @throws IOException 
	 */
	public int add(List<? extends Searchable> objs) throws IOException {
		if (objs == null || objs.size() == 0)
			return 0;
		int doc_count = 0;
		IndexWriter writer = getWriter(objs.get(0).getClass());
		try{
			for (Searchable obj : objs) {
				Document doc = SearchHelper.obj2doc(obj);				
				writer.addDocument(doc);
				doc_count++;
			}
			writer.commit();
		}finally{
			writer.close();
			writer = null;
		}
		return doc_count;
	}
	
	/**
	 * ����ɾ������
	 * @param docs
	 * @throws IOException 
	 */
	public int delete(List<? extends Searchable> objs) throws IOException {
		if (objs == null || objs.size() == 0)
			return 0;
		int doc_count = 0;
		IndexWriter writer = getWriter(objs.get(0).getClass());
		try{
			for (Searchable obj : objs) {
				writer.deleteDocuments(new Term("id", String.valueOf(obj.id())));
				doc_count++;
			}
			writer.commit();
		}finally{
			writer.close();
			writer = null;
		}
		return doc_count;
	}

	/**
	 * ������������
	 * @param docs
	 * @throws IOException 
	 */
	public void update(List<? extends Searchable> objs) throws IOException {
		delete(objs);
		add(objs);
	}
	
}