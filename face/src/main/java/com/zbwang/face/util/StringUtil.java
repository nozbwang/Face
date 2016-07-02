package com.zbwang.face.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class StringUtil {

	public static final Pattern pattern = Pattern.compile("~!([\\w]+)!~");

	public static String replaceVariables(String template, Map<String, String> variableMap) {
		Matcher matcher = pattern.matcher(template);
		while (matcher.find()) {
			template = StringUtils.replace(template, matcher.group(0), variableMap.get(matcher.group(1)));
		}
		return template;
	}

}
