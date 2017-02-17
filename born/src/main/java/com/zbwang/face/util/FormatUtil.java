package com.zbwang.face.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class FormatUtil {
	public static final Logger log = Logger.getLogger(FormatUtil.class);
	private static ThreadLocal<SimpleDateFormat> MINUTE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		};
	};
	private static ThreadLocal<SimpleDateFormat> DAILY_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		};
	};
	private static ThreadLocal<SimpleDateFormat> COLLECT_TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss");
		};
	};

	public static String formatMinuteTime(Date date) {
		if (date == null) {
			return MINUTE_FORMAT.get().format(new Date());
		}
		return MINUTE_FORMAT.get().format(date);
	}

	public static String formatDailyTime(Date date) {
		if (date == null) {
			return DAILY_FORMAT.get().format(new Date());
		}
		return DAILY_FORMAT.get().format(date);
	}

	public static Date parseDailyTime(String date) {
		try {
			if (StringUtils.isNotBlank(date)) {
				return MINUTE_FORMAT.get().parse(date);
			}
		} catch (ParseException e) {
			log.error("Fail to parse time :" + date, e);
		}
		return null;
	}

	public static Date getCollectTime(String date) {
		if (StringUtils.isBlank(date)) {
			return new Date();
		}
		try {
			return COLLECT_TIME_FORMAT.get().parse(date);
		} catch (ParseException e) {
			log.error("Fail to parse time :" + date);
		}
		return new Date();
	}
}
