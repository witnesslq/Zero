package com.zero.Lucene.index;

import com.zero.domainModel.Searchable;

/**
 * �������²���
 * @author Winter Lau
 */
public interface IndexTask {

	public byte OPT_ADD 	= 0x01;	//�������
	public byte OPT_UPDATE 	= 0x02;	//��������
	public byte OPT_DELETE 	= 0x04;	//ɾ������
	
	/**
	 * ���ظ��²�������
	 * @return �뿴������������
	 */
	public byte getOpt();
	
	/**
	 * ���ض�Ӧ�Ŀ���������
	 * @return
	 */
	public Searchable object();
	
	/**
	 * �����������²�����Ϻ�ִ�д˷���
	 */
	public void afterBuild();
	
}
