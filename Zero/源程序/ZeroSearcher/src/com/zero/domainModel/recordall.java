package com.zero.domainModel;
/** 
* <p>��  ����recordall
* <p>��  �ã�����һ����¼��
*/
public class recordall{
     String id;
	 String title;
	 String describe;
	 String date;

	
		/** 
		* <br>��������addjilu
		* <br>��  �ã����¼�������������
		* <br>��  ����String a,String b,String d,String e
		* <br>�������ͣ� �� 
		*/
	public void addrecord(String a,String b,String d,String e){
		this.id=a;
		this.title=b;
		this.describe=d;
		this.date=e;
	}
}