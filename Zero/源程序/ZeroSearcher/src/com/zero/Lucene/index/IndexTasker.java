package com.zero.Lucene.index;
import java.util.List;

/**
 * 定义用于获取索引更新任务的接口
 * @author Winter Lau
 */
public interface IndexTasker {

	/**
	 * 获取所有待处理的索引任务
	 * @return
	 */
	public List<IndexTask> list();
	
}
