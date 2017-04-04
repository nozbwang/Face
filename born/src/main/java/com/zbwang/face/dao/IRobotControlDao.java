package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.RobotControl;

public interface IRobotControlDao {
	void insertRobotControl(RobotControl robotControl);

	void disableControlSignal(List<Long> robotControlIds);

	List<RobotControl> queryForRobotControl(String uuid);

	List<RobotControl> queryForRobotControlSignal(String uuid);
}
