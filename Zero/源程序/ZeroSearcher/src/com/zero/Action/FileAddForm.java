package com.zero.Action;
import org.apache.struts.action.ActionForm;

/**
 * <p>������FileAddForm
 * <p>���ã������ԴAction��formbean���洢�ύ������Ҫ�ϴ����ļ���
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
	 * <br>��������getFiles
	 * <br>���ã���ȡҪ���ӵ���Դ
	 * <br>�������ͣ�String[]
	 */
	public String[] getFiles() {
		return files;
	}
	/**
	 * <br>��������setFiles
	 * <br>���ã�����Ҫ���ӵ���Դ
	 */
	public void setFiles(String[] files) {
		this.files = files;
	}
	/**
	 * <br>��������getKeywords
	 * <br>���ã���ȡҪ������Դ�Ĺؼ���
	 * <br>�������ͣ�String[]
	 */
	public String[] getKeywords() {
		return keywords;
	}
	/**
	 * <br>��������setKeywords
	 * <br>���ã�����Ҫ������Դ�Ĺؼ���
	 */
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	/**
	 * <br>��������getKind
	 * <br>���ã���ȡҪ������Դ���ļ�����
	 */
	public String[] getKind() {
		return kind;
	}
	/**
	 * <br>��������setKind
	 * <br>���ã�����Ҫ������Դ���ļ�����
	 */
	public void setKind(String[] kind) {
		this.kind = kind;
	}
	/**
	 * <br>��������getDescribe
	 * <br>���ã���ȡҪ������Դ������
	 */
	public String[] getDescribe() {
		return describe;
	}
	/**
	 * <br>��������setDescribe
	 * <br>���ã�����Ҫ������Դ������
	 */
	public void setDescribe(String[] describe) {
		this.describe = describe;
	}
	/**
	 * <br>��������getDate
	 * <br>���ã���ȡҪ������Դ������
	 */
	public String[] getDate() {
		return date;
	}
	/**
	 * <br>��������setDate
	 * <br>���ã�����Ҫ������Դ������
	 */
	public void setDate(String[] date) {
		this.date = date;
	}
	/**
	 * <br>��������getUrl
	 * <br>���ã���ȡҪ������Դ�ĵ�ַ
	 */
	public String[] getUrl() {
		return url;
	}
	/**
	 * <br>��������setUrl
	 * <br>���ã�����Ҫ������Դ�ĵ�ַ
	 */
	public void setUrl(String[] url) {
		this.url = url;
	}
	/**
	 * <br>��������getAuthor
	 * <br>���ã���ȡҪ������Դ������
	 */
	public String[] getAuthor() {
		return author;
	}
	/**
	 * <br>��������setAuthor
	 * <br>���ã�����Ҫ������Դ������
	 */
	public void setAuthor(String[] author) {
		this.author = author;
	}
	/**
	 * <br>��������getPublisher
	 * <br>���ã���ȡҪ������Դ�ķ�����λ
	 */
	public String[] getPublisher() {
		return publisher;
	}
	/**
	 * <br>��������setPublisher
	 * <br>���ã�����Ҫ������Դ�ķ�����λ
	 */
	public void setPublisher(String[] publisher) {
		this.publisher = publisher;
	}
}