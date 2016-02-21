package com.zero.read;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * ��URL�еĺ��е������ַ����д���,ת����UTF-8�ĸ�ʽ
 * @author ������
 *
 */
public final class URLProcessor {
	private URLProcessor() {
	}

	private static boolean isChinese(char ch) {
		if(String.valueOf(ch).matches("[\u4e00-\u9fa5]")) {
			return true;
		}
		return false;
	}
	/**
	 * ��URL�е������ַ�ת����UTF-8
	 * @param path URL��ַ
	 * @return ת����UTF-8���URL�ַ���
	 */
	public static String process(String path) {
		String temp = "";
		try {
			for (int i = 0; i < path.length(); i++) {
				char ch = ' ';
				ch = path.charAt(i);
				if (!isChinese(ch)) {
					temp = temp + ch;
					continue;
				}
				String utf = URLEncoder.encode(String.valueOf(ch), "utf-8");
				temp = temp + utf;
			}
			path = temp;

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return path;
	}
}