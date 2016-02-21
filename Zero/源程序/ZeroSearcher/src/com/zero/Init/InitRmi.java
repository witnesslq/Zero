package com.zero.Init;

import com.zero.util.UtilClass;
import com.zero.xml.ParseTestXml;

/** 
* <p>类名：init
* <p>作  用： 分布式的初始化 
*/
public class InitRmi  {

	/** 
	* <br>函数名： init
	* <br>作  用： 获取XML文件中的信息，并存储在系统中 
	* <br>参数： 无
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
      //使用TermRangeFilter进行范围过滤搜索
        //1.域   2.起始位置  3.结束位置   4.是否包含起始位置    5.是否包含结束位置   
//        UtilClass.filter1=new TermRangeFilter("filename","chs.a","chs.txt",true,true);
//        UtilClass.filter1=new TermRangeFilter( );
        //使用NumericRangeFilter进行过滤
//        UtilClass.filter2=NumericRangeFilter.newIntRange("size", 10, 5000, true, true);
//        //使用QueryWrapperFilter进行过滤
//        UtilClass.filter3=new QueryWrapperFilter(new WildcardQuery(new Term("filename", "*.ini")));
    }
}