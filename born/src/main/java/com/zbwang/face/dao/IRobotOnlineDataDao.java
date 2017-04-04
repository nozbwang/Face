package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.RobotOnlineData;

public interface IRobotOnlineDataDao {
	public void uploadOnlineData(RobotOnlineData robotOnlineData);

	List<RobotOnlineData> queryForRobotOnlineData(String uuid, int startIndex);

	int countRobotOnlineData(String uuid);
}
