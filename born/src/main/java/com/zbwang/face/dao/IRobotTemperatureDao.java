package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.RobotTemperature;

public interface IRobotTemperatureDao {
	public void uploadRobotTemperature(RobotTemperature robotTemperature);

	List<RobotTemperature> queryForRobotTemperature(String uuid, int startIndex);

	int countTemperature(String uuid);
}
