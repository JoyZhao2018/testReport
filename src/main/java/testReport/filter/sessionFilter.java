package testReport.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import testReport.initization.InitDataFromDB;

@WebFilter(filterName = "sessionFilter", urlPatterns = { "/*" })
public class sessionFilter implements Filter {
	@Autowired
	private InitDataFromDB initData;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession(false);
		String uri = request.getRequestURI();

		boolean needFilter = isNeedFilter(uri);//configura it in AA02
		if (!needFilter) { // 不需要过滤直接传给下一个过滤器
			filterChain.doFilter(servletRequest, servletResponse);
		} else { // 需要过滤器
			// session中包含user对象,则是登录状态
			if (session != null && session.getAttribute("user") != null) {
				filterChain.doFilter(request, response);
			} else {
				String requestType = request.getHeader("X-Requested-With");
				// 判断是否是ajax请求
				if (requestType != null && "XMLHttpRequest".equals(requestType)) {
					// response.getWriter().write(this.NO_LOGIN);
				}else {
					// 重定向到登录页(需要在static文件夹下建立此html文件)
					response.sendRedirect(request.getContextPath() + "/welcome/loginPage");
				}
				return;
			}
		}

	}

	private boolean isNeedFilter(String uri) {
		String[] urlList = initData.getURLList();
		// String[] urlList = {"/welcome/loginPage"};
		for (int i = 0; i < urlList.length; i++) {
			if (urlList != null && uri.equals(urlList[i])) {
				return false;
			}
			if(!"".equals(urlList[i]) && uri.indexOf(urlList[i]) > -1) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
