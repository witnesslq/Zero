package com.zero.Action;
import org.apache.struts.action.ActionForm;

/**
 * <p>类名：FileAddForm
 * <p>作用：添加资源Action的formbean，存储提交上来的要上传的文件名
 */
public class FileAddForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	String files[] = null;
	String keywords[] = null;
	String kind[] = null;
	String describe[] = null;
	String date[] = null;
	String url[] = null;
	String author[] = null;
	String publisher[] = null;

	/**
	 * <br>函数名：getFiles
	 * <br>作用：获取要增加的资源
	 * <br>返回类型：String[]
	 */
	public String[] getFiles() {
		return files;
	}
	/**
	 * <br>函数名：setFiles
	 * <br>作用：设置要增加的资源
	 */
	public void setFiles(String[] files) {
		this.files = files;
	}
	/**
	 * <br>函数名：getKeywords
	 * <br>作用：获取要增加资源的关键字
	 * <br>返回类型：String[]
	 */
	public String[] getKeywords() {
		return keywords;
	}
	/**
	 * <br>函数名：setKeywords
	 * <br>作用：设置要增加资源的关键字
	 */
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	/**
	 * <br>函数名：getKind
	 * <br>作用：获取要增加资源的文件类型
	 */
	public String[] getKind() {
		return kind;
	}
	/**
	 * <br>函数名：setKind
	 * <br>作用：设置要增加资源的文件类型
	 */
	public void setKind(String[] kind) {
		this.kind = kind;
	}
	/**
	 * <br>函数名：getDescribe
	 * <br>作用：获取要增加资源的描述
	 */
	public String[] getDescribe() {
		return describe;
	}
	/**
	 * <br>函数名：setDescribe
	 * <br>作用：设置要增加资源的描述
	 */
	public void setDescribe(String[] describe) {
		this.describe = describe;
	}
	/**
	 * <br>函数名：getDate
	 * <br>作用：获取要增加资源的日期
	 */
	public String[] getDate() {
		return date;
	}
	/**
	 * <br>函数名：setDate
	 * <br>作用：设置要增加资源的日期
	 */
	public void setDate(String[] date) {
		this.date = date;
	}
	/**
	 * <br>函数名：getUrl
	 * <br>作用：获取要增加资源的地址
	 */
	public String[] getUrl() {
		return url;
	}
	/**
	 * <br>函数名：setUrl
	 * <br>作用：设置要增加资源的地址
	 */
	public void setUrl(String[] url) {
		this.url = url;
	}
	/**
	 * <br>函数名：getAuthor
	 * <br>作用：获取要增加资源的作者
	 */
	public String[] getAuthor() {
		return author;
	}
	/**
	 * <br>函数名：setAuthor
	 * <br>作用：设置要增加资源的作者
	 */
	public void setAuthor(String[] author) {
		this.author = author;
	}
	/**
	 * <br>函数名：getPublisher
	 * <br>作用：获取要增加资源的发布单位
	 */
	public String[] getPublisher() {
		return publisher;
	}
	/**
	 * <br>函数名：setPublisher
	 * <br>作用：设置要增加资源的发布单位
	 */
	public void setPublisher(String[] publisher) {
		this.publisher = publisher;
	}
}