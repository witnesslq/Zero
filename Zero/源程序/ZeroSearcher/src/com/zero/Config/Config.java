package com.zero.Config;
/** 
* <p>类名：Config
* <p>作  用：记录整个工程中的系统配置 
*/

public class Config {
	/** 
	* <p>变量名：pagenum
	* <p>作  用：记录每页显示的数量 
	*/
public static int pagenum=10;
/** 
* <p>变量名：pagetype
* <p>作  用：记录分页方式（个性化分页、普通分页）
*/
public static String pagetype="default";       //personality

/** 
* <p>变量名：GuangGao
* <p>作  用：预留广告位
*/
public static String GuangGao="预留广告位";

/** 
* <p>变量名：TanGuangGao
* <p>作  用：控制是否弹出广告位
*/
public static boolean TanGuangGao=false;

/** 
* <p>变量名：molin
* <p>作  用：控制是否弹出小助手
*/
public static boolean molin=false;
}