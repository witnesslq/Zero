package com.zero.domainModel;
import java.util.List;
import java.util.Map;

/**
 * ����������
 * User: Winter Lau
 * Date: 13-1-10
 * Time: ����11:31
 */
public interface Searchable extends Comparable<Searchable> {

	public String FN_ID = "id";
	public String FN_TITLE 	= "title";
//	public String FN_DETAIL	= "detail";	
	public String FN_KEYWORDS = "keywords";
	public String FN_KIND="kind";
	public String FN_DESCRIBE="describe";
	public String FN_DATA="date";
	public String FN_URL="url";
	public String FN_AUTHOR="author";
	public String FN_PUBLISHER="publisher";
	public String FN_CONTENT="content";
    /**
     * �ĵ���Ψһ���
     * @return �ĵ�id
     */
    public long id();
    public void setId(long id);

    /**
     * Ҫ�洢���ֶ�
     * @return �����ֶ����б�
     */
    public List<String> storeFields();

    /**
     * Ҫ���зִ��������ֶ�
     * @return �����ֶ����б�
     */
    public List<String> indexFields();

    /**
     * �ĵ������ȼ�
     * @return
     */
    public float boost();
    
    /**
     * ��չ�Ĵ洢����
     * @return ��չ����K/V
     */
    public Map<String, String> extendStoreDatas();

    /**
     * ��չ����������
     * @return ��չ����K/V
     */
    public Map<String, String> extendIndexDatas();

    /**
     * �г�idֵ����ָ��ֵ�����ж���
     * @param id
     * @param count
     * @return
     */
	public List<? extends Searchable> ListAfter(long id, int count) ;
}
