package com.zero.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>类名：CharFilter
 * <p>作用：字符编码过滤器
 */
public class CharFilter implements Filter {

    //字符编码过滤器
	/**
	 * <br>函数名：destroy
	 * <br>作用：释放
	 */
	public void destroy() {
	
	}
	
	/**
	 * <br>函数名：doFilter
	 * <br>作用：字符编码过滤主方法
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		    request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
		    chain.doFilter(request, response);
	}
	/**
	 * <br>函数名：init
	 * <br>作用：字符编码过滤初始化
	 */
	public void init(FilterConfig filterCon) throws ServletException {

	}

}