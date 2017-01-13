package com.zbwang.face.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.zbwang.face.constant.Constants;
import com.zbwang.face.util.CookieUtil;
import com.zbwang.face.util.FormatUtil;

public class LoginFilter extends OncePerRequestFilter {
	public void destroy() {
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String lvt = CookieUtil.getCookieValue(request, Constants.COOKIE_LOGIN_LVT);
		Date lastVistTime = FormatUtil.parseDailyTime(lvt);
		HttpSession session = request.getSession();
		if (lastVistTime != null && inLoginValidTime(lastVistTime)) {
			CookieUtil.addLVTCookie(response);
			String userId = CookieUtil.getDecryptCookieValue(request, Constants.COOKIE_LOGIN);
			if (StringUtils.isNotBlank(userId)) {
				session.setAttribute(Constants.SESSION_LOGIN, userId);
			} else {
				session.removeAttribute(Constants.SESSION_LOGIN);
			}
		} else {
			session.removeAttribute(Constants.SESSION_LOGIN);
		}
		filterChain.doFilter(request, response);
	}

	private boolean inLoginValidTime(Date lastVistTime) {
		return new Date().getTime() - lastVistTime.getTime() < Constants.VALID_VISIT_TIME;
	}
}
