package com.zbwang.face.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class FormatUtil {

	public static final Logger log = Logger.getLogger(FormatUtil.class);

	private static ThreadLocal<SimpleDateFormat> dailyFormat = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		};
	};

	public static String formatDailyTime(Date date) {
		return dailyFormat.get().format(date);
	}

	public static Date parseDailyTime(String date) {
		try {
			if (StringUtils.isNotBlank(date)) {
				return dailyFormat.get().parse(date);
			}
		} catch (ParseException e) {
			log.error("Fail to parse time :" + date, e);
		}
		return null;
	}

}
