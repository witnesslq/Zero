package com.zero.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.zero.util.UtilClass;

/**
 * ���ڻ�ȡԶ����Դ��inputStream����
 * @author ������
 *
 */
public class GetRemoteResource {
	private GetRemoteResource(){}
	/**
	 * ��ȡԶ����Դ��inputStream
	 * @param path Զ����Դ��URL
	 * @return Զ����Դ��inputStream,�������򷵻�null;
	 */
	public static InputStream getInputStream(String path) {
		String[] paths = path.split("/");
		path = UtilClass.getPath("webapps");
		int s = paths.length;
		path = path + "\\" + paths[s-2] + "\\" + paths[s-1];
		InputStream in = null;
		FileInputStream fis = null;
		File file = null;		
		try {
			file = new File(path);
			fis = new FileInputStream(file);
			in = fis;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(path);
		}		
		return in;
	}
	
	/**
	 * path = URLProcessor.process(path);
		HttpURLConnection httpUrl = null;
		InputStream in = null;
		URL url;
		try {
			url = new URL(path);
			httpUrl = (HttpURLConnection) url.openConnection();
			httpUrl.connect();
			in = httpUrl.getInputStream();
		} catch (FileNotFoundException e) {
			return null;
		}catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		return in;
	 */
}