package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.RobotUserRelation;

public interface IRobotUserRelationDao {
	public Long bindRobot(RobotUserRelation robotUserRelation);

	RobotUserRelation queryForRobotByUuid(String uuid);

	List<RobotUserRelation> queryForBindedRobot(Long userId, Short robotType);

	List<RobotUserRelation> queryForBindedRobot(Long userId);

	void deleteRobot(String uuid, Long userId);
}
