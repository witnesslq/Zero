package com.zero.Lucene.index;
import java.util.List;

/**
 * �������ڻ�ȡ������������Ľӿ�
 * @author Winter Lau
 */
public interface IndexTasker {

	/**
	 * ��ȡ���д��������������
	 * @return
	 */
	public List<IndexTask> list();
	
}
