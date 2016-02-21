package com.zero.read;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 对URL中的含有的中文字符进行处理,转化成UTF-8的格式
 * @author 林银龙
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
	 * 将URL中的中文字符转化成UTF-8
	 * @param path URL地址
	 * @return 转换成UTF-8后的URL字符串
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