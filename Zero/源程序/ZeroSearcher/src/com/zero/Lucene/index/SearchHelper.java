package com.zero.Lucene.index;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.zero.domainModel.Searchable;

/**
 * ����������
 * User: Winter Lau
 * Date: 13-1-10
 * Time: ����11:54
 */
public class SearchHelper {

    private final static Log log = LogFactory.getLog(SearchHelper.class);
    private final static IKAnalyzer analyzer = new IKAnalyzer();
	private final static BooleanQuery nullQuery = new BooleanQuery();
    private final static Formatter highlighter_formatter = new SimpleHTMLFormatter("<span class=\"highlight\">","</span>");

    public final static String FN_ID = "___id";
    public final static String FN_CLASSNAME = "___class";

    @SuppressWarnings("serial")
	private final static List<String> nowords = new ArrayList<String>(){{
        try{
            addAll(IOUtils.readLines(SearchHelper.class.getResourceAsStream("/stopword.dic")));
        }catch(IOException e){
            log.error("Unabled to read stopword file", e);
        }
    }};    

	@SuppressWarnings("serial")
	private final static List<String> ReserveKeys = new ArrayList<String>(){{		
        try{
            addAll(IOUtils.readLines(SearchHelper.class.getResourceAsStream("/keywords.dic")));
        }catch(IOException e){
            log.error("Unabled to read keywords file", e);
        }
	}};

	/**
	 * ���������ؼ�����
	 * @param key
	 * @return
	 */
	public static String cleanupKey(String key) {
		if(ReserveKeys.contains(key.trim().toLowerCase()))
			return key;
		
		StringBuilder sb = new StringBuilder();
		List<String> keys = splitKeywords(key);
		for(String word : keys){
			if(sb.length() > 0)
				sb.append(' ');
			sb.append(word);
		}
		
		return sb.toString();
	}	
	
    /**
     * ���ɲ�ѯ����
     * @param field
     * @param q
     * @param boost
     * @param machine_action
     * @return
     */
	public static Query makeQuery(String field, String q, float boost) {
		if(StringUtils.isBlank(q) || StringUtils.isBlank(field))
			return nullQuery;
		QueryParser parser = new QueryParser(Version.LUCENE_40, field, analyzer);
		parser.setDefaultOperator(QueryParser.AND_OPERATOR);
		try{
			Query querySinger = parser.parse(q);
			querySinger.setBoost(boost);
			//System.out.println(querySinger.toString());
			return querySinger;
		}catch(Exception e){
			TermQuery queryTerm = new TermQuery(new Term(field, q));
			queryTerm.setBoost(boost);
			//System.out.println(queryTerm.toString());
			return queryTerm;
		}
	}
	

    /**
     * �ؼ����з�
     * @param sentence Ҫ�ִʵľ���
     * @return ���طִʽ��
     */
    public static List<String> splitKeywords(String sentence) {
        List<String> keys = new ArrayList<String>();
        if(StringUtils.isNotBlank(sentence))  {
            StringReader reader = new StringReader(sentence);
            IKSegmenter ikseg = new IKSegmenter(reader, true);
            try{
                do{
                    Lexeme me = ikseg.next();
                    if(me == null){
                        break;
                    }
                    String term = me.getLexemeText();
                    if(nowords.contains(term.toLowerCase())){
                    	//���зֳ����Ĺؼ��ʽ��б�������stopwords���򲻽������Ϊ�����ʣ����������
                        continue;
                    }
                    keys.add(term);
                }while(true);
            }catch(IOException e){
                log.error("Unable to split keywords", e);
            }
        }

        return keys;
    }

    /**
     * ��һ���ı�ִ���﷨��������
     * @param text Ҫ����������ı�
     * @param key �����Ĺؼ���
     * @return ���ظ�ʽ�����HTML�ı�
     */
    public static String highlight(String text, String key) {
    	//����ؼ��ʺ��ı��κ�һ��Ϊ�ն������ı����и�������ֱ�ӷ����ı�
        if(StringUtils.isBlank(key) || StringUtils.isBlank(text)){
            return text;
        }
        String result = null;//�ؼ��ʲ�Ϊ�գ����и�������
        try {
        	//�Եõ����зֺ�Ĺؼ��ʽ��д���
        	{
        		PhraseQuery pquery = new PhraseQuery();
        		for(String sk : splitKeywords(key)){
        			//�õ��зֺ��Ҫ�����Ĺؼ���
        			pquery.add(new Term("",QueryParser.escape(sk)));
        		}
        		QueryScorer scorer = new QueryScorer(pquery);
        		Highlighter hig = new Highlighter(highlighter_formatter, scorer);
        		TokenStream tokens = analyzer.tokenStream(null, new StringReader(text));
        		result = hig.getBestFragment(tokens, text);
        	}
        } catch (Exception e) {
            log.error("Unabled to hightlight text", e);
        }
        return (result != null)?result:text;
    }
    
    /**
     * �����ĵ��б���Ķ��� id
     * @param doc
     * @return
     */
    public static long docid(Document doc) {
    	return NumberUtils.toLong(doc.get(FN_ID), 0);
    }
    
    /**
     * ��ȡ�ĵ���Ӧ�Ķ�����
     * @param doc
     * @return
     * @throws ClassNotFoundException 
     */
	public static Searchable doc2obj(Document doc) {
    	try{
    		long id = docid(doc);
    		if(id <= 0)
    			return null;
    		Searchable obj = (Searchable)Class.forName(doc.get(FN_CLASSNAME)).newInstance();
    		obj.setId(id);
    		return obj;
    	}catch(Exception e){
    		log.error("Unabled generate object from document#id="+doc.toString(), e);
    		return null;
    	}
    }

    /**
     * ������ת�� Lucene ���ĵ�
     * @param obj Java ����
     * @return ����Lucene�ĵ�
     */
    public static Document obj2doc(Searchable obj) {
        if(obj == null)
            return null;

        Document doc = new Document();
        doc.add(new LongField(FN_ID, obj.id(), Field.Store.YES));
        doc.add(new StoredField(FN_CLASSNAME, obj.getClass().getName()));

        //�洢�ֶ�
        List<String> fields = obj.storeFields();
        if(fields != null)
            for(String fn : fields) {
                Object fv = readField(obj, fn);
                if(fv != null)
                	doc.add(obj2field(fn, fv, true));
            }

        //��չ�洢�ֶ�
        Map<String, String> eDatas = obj.extendStoreDatas();
        if(eDatas != null)
            for(String fn : eDatas.keySet()){
            	if(fields != null && fields.contains(fn))
            		continue;
                String fv = eDatas.get(fn);
                if(fv != null)
                	doc.add(obj2field(fn, fv, true));
            }

        //�����ֶ�
        fields = obj.indexFields();
        if(fields != null)
            for(String fn : fields) {
                String fv = (String)readField(obj, fn);
                if(fv != null){
                	TextField tf = new TextField(fn, fv, Field.Store.NO);
                	tf.setBoost(obj.boost());
                	doc.add(tf);
                }
            }

        //��չ�����ֶ�
        eDatas = obj.extendIndexDatas();
        if(eDatas != null)
            for(String fn : eDatas.keySet()){
            	if(fields != null && fields.contains(fn))
            		continue;
                String fv = eDatas.get(fn);
                if(fv != null){
                	TextField tf = new TextField(fn, fv, Field.Store.NO);
                	tf.setBoost(obj.boost());
                	doc.add(tf);
                }
            }

        return doc;
    }

    /**
     * ���ʶ���ĳ�����Ե�ֵ
     *
     * @param obj ����
     * @param field ������
     * @return  Lucene �ĵ��ֶ�
     */
    private static Object readField(Object obj, String field) {
        try {
            return PropertyUtils.getProperty(obj, field);
        } catch (Exception e) {
            log.error("Unabled to get property '"+field+"' of " + obj.getClass().getName(), e);
            return null;
        }

    }

    private static Field obj2field(String field, Object fieldValue, boolean store) {
    	if(fieldValue == null)
    		return null;
    	
        if (fieldValue instanceof Date) //����
            return new LongField(field, ((Date)fieldValue).getTime(), store?Field.Store.YES:Field.Store.NO);
        if (fieldValue instanceof Number) //������ֵ
            return new StringField(field, String.valueOf(((Number)fieldValue).longValue()), store?Field.Store.YES:Field.Store.NO);
        //����Ĭ�ϵ��ַ�������
        return new StringField(field, (String)fieldValue, store?Field.Store.YES:Field.Store.NO);
    }

}