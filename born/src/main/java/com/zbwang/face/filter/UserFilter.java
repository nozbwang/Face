package com.zbwang.face.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.zbwang.face.constant.Constants;
import com.zbwang.face.domain.User;
import com.zbwang.face.dto.BaseCommand;
import com.zbwang.face.service.IUserService;
import com.zbwang.face.service.impl.ContextService;
import com.zbwang.face.util.SecurityInfoHolder;

public class UserFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String userId = (String) WebUtils.getSessionAttribute(request, Constants.SESSION_LOGIN);
		IUserService faceUserService = (IUserService) ContextService.getBean(IUserService.class);
		User user = faceUserService.getUser(NumberUtils.toInt(userId));
		SecurityInfoHolder.setSecurityInfo(new BaseCommand(user));
		filterChain.doFilter(request, response);
		SecurityInfoHolder.setSecurityInfo(null);
	}
}
