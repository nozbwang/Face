package com.zbwang.face.util;

import com.zbwang.face.command.BaseCommand;

public class SecurityInfoHolder {

	private static ThreadLocal<BaseCommand> securityInfo = new ThreadLocal<BaseCommand>();

	public static BaseCommand getSecurityInfo() {
		return securityInfo.get();
	}

	public static void setSecurityInfo(BaseCommand command) {
		securityInfo.set(command);
	}

}
