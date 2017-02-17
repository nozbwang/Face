package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.RobotControl;

public interface IRobotControlDao {
	void insertRobotControl(RobotControl robotControl);

	List<RobotControl> queryForRobotControl(Long robotId);

	List<RobotControl> queryForRobotControlSignal(Long robotId);

	void disableControlSignal(List<Long> robotControlIds);
}
