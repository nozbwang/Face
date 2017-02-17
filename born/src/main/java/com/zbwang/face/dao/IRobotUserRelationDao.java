package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.RobotUserRelation;

public interface IRobotUserRelationDao {
	public Long bindRobot(RobotUserRelation robotUserRelation);

	List<RobotUserRelation> queryForBindedRobot(Long userId);

	RobotUserRelation queryForRobotByUuid(String uuid);
}
