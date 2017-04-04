package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.RobotMotion;

public interface IRobotMotionDao {
	public void uploadRobotMotion(RobotMotion robotMotion);

	List<RobotMotion> queryForRobotMotion(String uuid, int startIndex);

	int countRobotMotion(String uuid);
}
