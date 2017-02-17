package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.RobotTemperature;

public interface IRobotTemperatureDao {
	public void uploadRobotTemperature(RobotTemperature robotTemperature);

	List<RobotTemperature> queryForRobotTemperature(Long robotId);
}
