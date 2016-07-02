package com.zbwang.face.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.zbwang.face.constant.FaceConstants;

public class CookieUtil {

	private static final Logger log = Logger.getLogger(CookieUtil.class);

	public static String getCookieValue(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if (ArrayUtils.isNotEmpty(cookies)) {
			for (Cookie cookie : cookies) {
				if (StringUtils.equals(key, cookie.getName())) {
					return getDecodeCookieValue(cookie);
				}
			}
		}
		return StringUtils.EMPTY;
	}

	public static void removeLGCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie(FaceConstants.COOKIE_LOGIN, null);
		cookie.setDomain(".bobomeilin.com");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	public static void addLGCookie(HttpServletResponse response, String UserId) {
		Cookie cookie = new Cookie(FaceConstants.COOKIE_LOGIN, UserId);
		cookie.setDomain(".bobomeilin.com");
		cookie.setPath("/");
		cookie.setMaxAge(FaceConstants.COOKIE_SESSION);
		addHttpOnlyCookie(response, cookie);
	}

	public static void addLVTCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie(FaceConstants.COOKIE_LOGIN_LVT, FormatUtil.formatDailyTime(new Date()));
		cookie.setDomain(".bobomeilin.com");
		cookie.setPath("/");
		cookie.setMaxAge(FaceConstants.COOKIE_SESSION);
		addHttpOnlyCookie(response, cookie);
	}

	public static void removeLVTCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie(FaceConstants.COOKIE_LOGIN_LVT, null);
		cookie.setDomain(".bobomeilin.com");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	public static void addHttpOnlyCookie(HttpServletResponse response, Cookie cookie) {
		// 依次取得cookie中的名称、值、最大生存时间、路径、域和是否为安全协议信息
		String cookieName = cookie.getName();
		String cookieValue = getEncodeCookieValue(cookie);
		int maxAge = cookie.getMaxAge();
		String path = cookie.getPath();
		String domain = cookie.getDomain();
		StringBuffer strBufferCookie = new StringBuffer();
		strBufferCookie.append(cookieName + "=" + cookieValue + ";");
		if (maxAge != FaceConstants.COOKIE_SESSION) {
			strBufferCookie.append("Max-Age=" + cookie.getMaxAge() + ";");
		}
		if (domain != null) {
			strBufferCookie.append("domain=" + domain + ";");
		}
		if (path != null) {
			strBufferCookie.append("path=" + path + ";");
		}
		strBufferCookie.append("HTTPOnly;");
		response.addHeader("Set-Cookie", strBufferCookie.toString());
	}

	private static String getEncodeCookieValue(Cookie cookie) {
		try {
			return URLEncoder.encode(cookie.getValue(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("Fail to encode cookie value. ", e);
		}
		return StringUtils.EMPTY;
	}

	private static String getDecodeCookieValue(Cookie cookie) {
		try {
			return URLDecoder.decode(cookie.getValue(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("Fail to encode cookie value. ", e);
		}
		return StringUtils.EMPTY;
	}

}
