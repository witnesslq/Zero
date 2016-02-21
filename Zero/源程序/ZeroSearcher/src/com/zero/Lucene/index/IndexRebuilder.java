package com.zero.Lucene.index;
import java.util.List;

import org.apache.commons.cli.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zero.domainModel.Searchable;

/**
 * �ؽ�����
 * User: Winter Lau
 * Date: 13-1-10
 * Time: ����11:42
 */
public class IndexRebuilder {

	private final static Log log = LogFactory.getLog(IndexRebuilder.class);
	private final static int DEFAULT_BATCH_COUNT = 2000;

	private final static Options options = new Options(){{
		addOption("s", "batch_size",true, "Objects count one time");
		addOption("p", "path", 		true, "Lucene index root path");
		addOption("b", "beans", 	true, "Beans classes, use comma to seperate multiple class");
		addOption("h", "help", 		true, "Print this message");
	}};	
	
    public static void main(String[] args) throws Exception {
		//��������
		CommandLine cmd = parseCmdArgs(args);
		String idx_path = cmd.getOptionValue('p');
		String beans = cmd.getOptionValue('b');
		if(StringUtils.isBlank(idx_path) || StringUtils.isBlank(beans)){
			 new HelpFormatter().printHelp("java -Djava.ext.dirs=lib net.oschina.search.IndexRebuilder [options]", options);
			 System.exit(-1);
		}
		//ÿ���δ�������������������ֵ�����ѹ��������ܣ���Ҫע���ڴ��Ƿ��㹻
		int batch_count = NumberUtils.toInt(cmd.getOptionValue('s'), DEFAULT_BATCH_COUNT);
		//��ʼ������������
		IndexHolder holder = IndexHolder.init(idx_path);
		for(String beanClass : StringUtils.split(beans, ',')){
			//Searchable obj = (Searchable)IndexRebuilder.class.getClassLoader().loadClass(beanClass).newInstance();
			Searchable obj = (Searchable)Class.forName(beanClass).newInstance();
			build(holder, obj, batch_count);
			holder.optimize(obj.getClass());
		}
		System.exit(0);
    }

	private static CommandLine parseCmdArgs(String[] args) {
		CommandLineParser parser = new PosixParser();
		try {
			return parser.parse( options, args);
		} catch (ParseException e) {
	        log.error("Arguments parsing failed.", e);
		}
		return null;
	}
	
	/**
	 * ��������
	 * @param holder
	 * @param objClass
	 * @param batch_count
	 * @return
	 */
	private static int build(IndexHolder holder, Searchable obj, int batch_count) throws Exception {
		int ic = 0;
		long last_id = 0L;
		do {
			List<? extends Searchable> objs = obj.ListAfter(last_id, batch_count);
			if(objs != null && objs.size()>0){
				ic  += holder.add(objs);
				last_id = objs.get(objs.size()-1).id();

				log.info(ic + " documents of " + obj.getClass().getSimpleName() + " added.");
			}
			if(objs == null || objs.size() < batch_count)
				break;
		}while(true);
		
		return ic;
	}
	
}
