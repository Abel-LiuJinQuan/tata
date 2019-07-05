package com.hita.tata.common.filter;

import com.hita.tata.common.entity.user.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户验证拦截器
 * @author abel
 */
//@Component
//@javax.servlet.annotation.WebFilter(filterName = "WebFilter",urlPatterns = "/bbs/*")
public class WebFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
				ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("user");
		if (user != null){
			chain.doFilter(req, resp);
		}else{
			String message = "用户尚未登录！";
			request.getSession().setAttribute("msg",message);
			response.sendRedirect("/show/getLogin");//重定向到登录页面
		}
	}

	@Override
	public void destroy() {

	}
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//
//	}
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
//		HttpServletResponse response = (HttpServletResponse) resp;
//		HttpSession session = request.getSession();
//		User user =(User) session.getAttribute("user");
//		if (user != null){
//			chain.doFilter(req, resp);
//		}else{
//			String message = "您没有权限访问该页面";
//			request.getSession().setAttribute("msg","message");
//			response.sendRedirect("/login");//重定向到登录页面
//		}
//	}
//
//	@Override
//	public void destroy() {
//
//	}
}
