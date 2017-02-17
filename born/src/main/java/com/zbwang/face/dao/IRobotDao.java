package com.zbwang.face.dao;

import com.zbwang.face.domain.Robot;

public interface IRobotDao {
	Long insertRobot(Robot robot);

	Integer uploadRobotStatus(String uuid, String status);
}
