package com.zbwang.face.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.zbwang.face.command.BaseCommand;
import com.zbwang.face.constant.FaceConstants;
import com.zbwang.face.domain.FaceUser;
import com.zbwang.face.service.FaceUserService;
import com.zbwang.face.service.impl.ApplicationContextHolder;
import com.zbwang.face.util.SecurityInfoHolder;

public class BaseInfoFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		SecurityInfoHolder securityInfoHoler = new SecurityInfoHolder();
		BaseCommand command = new BaseCommand();
		String userId = (String) WebUtils.getSessionAttribute(request, FaceConstants.SESSION_LOGIN);
		FaceUserService faceUserService = (FaceUserService) ApplicationContextHolder.getBean(FaceUserService.class);
		FaceUser user = faceUserService.getUser(NumberUtils.toInt(userId));
		command.setUser(user);
		securityInfoHoler.setSecurityInfo(command);
		filterChain.doFilter(request, response);
		securityInfoHoler.setSecurityInfo(null);
	}

}
