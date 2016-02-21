package com.zero.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>类名：SetCharacterEncodingFilter
 * <p>作用：字符编码过滤器
 */
public class SetCharacterEncodingFilter implements Filter {

	/**
	 * <br>函数名：init
	 * <br>作用：字符编码过滤器初始化
	 */
	public void init(FilterConfig filterConfig) throws ServletException{

	}
	

	/**
	 * <br>函数名：doFilter
	 * <br>作用：字符编码过滤器主方法
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		    request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
		    chain.doFilter(request, response);
	}
	
	/**
	 * <br>函数名：destroy
	 * <br>作用：释放
	 */
	public void destroy(){
		
	}
	
}