package com.zero.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>������SetCharacterEncodingFilter
 * <p>���ã��ַ����������
 */
public class SetCharacterEncodingFilter implements Filter {

	/**
	 * <br>��������init
	 * <br>���ã��ַ������������ʼ��
	 */
	public void init(FilterConfig filterConfig) throws ServletException{

	}
	

	/**
	 * <br>��������doFilter
	 * <br>���ã��ַ����������������
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		    request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
		    chain.doFilter(request, response);
	}
	
	/**
	 * <br>��������destroy
	 * <br>���ã��ͷ�
	 */
	public void destroy(){
		
	}
	
}