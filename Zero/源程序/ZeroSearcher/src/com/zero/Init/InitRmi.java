package com.zero.Init;

import com.zero.util.UtilClass;
import com.zero.xml.ParseTestXml;

/** 
* <p>������init
* <p>��  �ã� �ֲ�ʽ�ĳ�ʼ�� 
*/
public class InitRmi  {

	/** 
	* <br>�������� init
	* <br>��  �ã� ��ȡXML�ļ��е���Ϣ�����洢��ϵͳ�� 
	* <br>������ ��
	*/
	public InitRmi(){
        UtilClass.setHostip(ParseTestXml.getHostIP());
        UtilClass.setRemoteip(ParseTestXml.getRemoteIP());
//        UtilClass.result = ParseTestXml.parseXml();
//        IndexHolder in = null;
//        try {
//			in = IndexHolder.init(UtilClass.getPath("webapps")+"\\index\\");
//			in.add(UtilClass.result);
//			in.optimize(Result.class);
//        } catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
      //ʹ��TermRangeFilter���з�Χ��������
        //1.��   2.��ʼλ��  3.����λ��   4.�Ƿ������ʼλ��    5.�Ƿ��������λ��   
//        UtilClass.filter1=new TermRangeFilter("filename","chs.a","chs.txt",true,true);
//        UtilClass.filter1=new TermRangeFilter( );
        //ʹ��NumericRangeFilter���й���
//        UtilClass.filter2=NumericRangeFilter.newIntRange("size", 10, 5000, true, true);
//        //ʹ��QueryWrapperFilter���й���
//        UtilClass.filter3=new QueryWrapperFilter(new WildcardQuery(new Term("filename", "*.ini")));
    }
}