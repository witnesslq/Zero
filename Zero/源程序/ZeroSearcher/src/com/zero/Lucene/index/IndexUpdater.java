package com.zero.Lucene.index;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zero.domainModel.Searchable;

/**
 * ������������
 * ���������������
 * idx_path ������Ŀ¼
 * tasker �����ȡʵ����
 * 
 * ��Ӧ build.xml ������
 * 
    <target depends="lucene_init" name="lucene_build">
        <echo message="Build lucene index of ${ant.project.name}"/>    	
		<java classname="com.zero.lucene.index.IndexTasker" classpathref="ZeroSearch.classpath" fork="true">
			<jvmarg value="-Xmx512m" />			
			<arg value="-p" />			
			<arg value="${lucene.dir}" />			
			<arg value="-t" />			
			<arg value="com.zero.lucene.index.IndexTasker" />
		</java>
	</target>
	
 * @author Winter Lau
 */
public class IndexUpdater {

	private final static Log log = LogFactory.getLog(IndexUpdater.class);
	
	private final static Options options = new Options(){{
		addOption("p", "path", 		false, "Lucene index root path");
		addOption("t", "tasker", 	false, "net.oschina.common.search.IndexTasker");
		addOption("h", "help", 		false, "Print this message");
	}};	
	
	public static void main(String[] args) throws Exception {
		//��������
		CommandLine cmd = parseCmdArgs(args);
		String idx_path = cmd.getOptionValue('p');//Lucene index root path
		System.out.println(idx_path);
		String taskerClassname = cmd.getOptionValue('t');//Full classname of the tasker
		System.out.println(taskerClassname);
		//�ж�idx_path��taskerClassname�Ƿ�Ϊ�գ�������ִ���
		if(StringUtils.isBlank(idx_path) || StringUtils.isBlank(taskerClassname)){
			 new HelpFormatter().printHelp("java -Djava.ext.dirs=lib net.oschina.search.IndexUpdater [options]", options);
//			 System.exit(-1);
		}
		IndexTasker tasker = null;
		try{
			//����
//			tasker = (IndexTasker)Class.forName("net.oschina.common.search.IndexTasker").newInstance();
			tasker = (IndexTasker)Class.forName(cmd.getOptionValue('t')).newInstance();
		}catch(Exception e){
			log.error("Unabled to instantiate index loader", e);
			System.exit(-2);
		}
		//��ʼ������������
		IndexHolder holder = IndexHolder.init(idx_path);
		
		//������������
		List<IndexTask> tasks = tasker.list();

		for(IndexTask task : tasks) {
			execute(holder, task, true);
		}

		if(tasks.size()>0){
			log.info(tasks.size()+ " Index tasks executed finished.");
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
	 * ��������������
	 * @param holder
	 * @param task
	 * @param update_status
	 * @throws Exception
	 */
	private static void execute(IndexHolder holder, IndexTask task, boolean update_status) throws Exception {
		Searchable obj = (Searchable)task.object();
		if(obj != null){
			switch(task.getOpt()){
			case IndexTask.OPT_ADD:
				holder.add(Arrays.asList(obj));
				break;
			case IndexTask.OPT_DELETE:
				holder.delete(Arrays.asList(obj));
				break;
			case IndexTask.OPT_UPDATE:
				holder.update(Arrays.asList(obj));
			}
			if(update_status)
				task.afterBuild();
		}
	}

}
