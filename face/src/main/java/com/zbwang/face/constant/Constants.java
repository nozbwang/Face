package com.zbwang.face.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Constants {
	public static String USERNAME_PATTERN = "^[a-zA-Z0-9]+$";
	public static String PASSWORD_PATTERN = "^[a-zA-Z0-9@]+$";
	public static String EMAIL_PATTERN = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]+$";

	// Session prefix
	public static String SESSION_LOGIN = "LG";

	// Cookie name
	public static String COOKIE_LOGIN = "LG";
	public static String COOKIE_LOGIN_LVT = "LVT";
	public static int COOKIE_SESSION = -2;

	// time
	public static int VALID_VISIT_TIME = 365 * 24 * 60 * 60 * 1000;

	// Content-Type
	// pic
	public static final List<String> picContentTypes = new ArrayList<String>() {
		{
			add("image/png");
			add("image/jpeg");
			add("image/bmp");
			add("image/pjpeg");
			add("image/x-png");
			add("image/gif");
		}
	};
	// music
	public static final List<String> musicContentTypes = new ArrayList<String>() {
		{
			add("audio/mp3");
			add("audio/wav");
		}
	};
	// video
	public static final List<String> videoContentTypes = new ArrayList<String>() {
		{
			add("video/mp4");
			add("video/ogg");
		}
	};

	public static String EMPTY_FILE_TYPE = "application/octet-stream";

	public static String LINK_PICTURE = "0";
	public static String LINK_MUSIC = "1";

	public static String MUSIC_UNKNOWN = "0";
	public static String MUSIC_163 = "1";
	public static String MUSIC_XIAMI = "2";

	// http://music.163.com/#/m/song?id=34125287
	// http://music.163.com/song/27501214/?userid=130594080
	public static Pattern MUSIC_163_PATTERN_PC = Pattern.compile(".*music\\.163\\.com.*id=([0-9]+).*");
	public static Pattern MUSIC_163_PATTERN_M = Pattern.compile(".*music\\.163\\.com/song/([0-9]+).*");

	// http://www.xiami.com/widget/0_1774465571/singlePlayer.swf
	public static Pattern MUSIC_XIAMI_PATTERN_PC = Pattern.compile(".*www\\.xiami\\.com.*/0_([0-9]+)/.*");
	public static Pattern PICTURE_PATTERN = Pattern.compile("http[s]?://.+(?:jpg|gif|png|bmp|jpeg)");

	public static final int ID_UNKOWN = 0;

	public static final int PICTURE_NAME_MAX_LENGTH = 50;
	public static final int NOTICE_MAIL_TITLE_LENGTH = 20;

	public static final String photoDiv = "<a href=\"http://www.bobomeilin.com/bigAttach?attachId={0}\"><img src=\"http://www.bobomeilin.com/attach?attachId={0}\"></a>";

	// 类型
	public static final String B_TYPE_BOOK = "1";
	public static final String B_TYPE_FOOT = "2";
	public static final String B_TYPE_TREEHOLE = "3";
	public static final String B_TYPE_HOME = "4";

	// 基础参数类型
	public static final String HOME = "home";

	// BOOK
	public static final String BOOK_LITERATURE = "literature";
	public static final String BOOK_POPULAR = "popular";
	public static final String BOOK_CULTURE = "culture";
	public static final String BOOK_LIFE = "life";
	public static final String BOOK_MANAGE = "manage";
	public static final String BOOK_SCIENCE = "science";

	public static final Map<String, String> catalogMap = new HashMap<String, String>();
	static {
		catalogMap.put(BOOK_LITERATURE, "1");
		catalogMap.put(BOOK_POPULAR, "2");
		catalogMap.put(BOOK_CULTURE, "3");
		catalogMap.put(BOOK_LIFE, "4");
		catalogMap.put(BOOK_MANAGE, "5");
		catalogMap.put(BOOK_SCIENCE, "6");
	}
}