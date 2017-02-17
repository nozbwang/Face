package com.zbwang.face.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.IRobotUserRelationDao;
import com.zbwang.face.domain.RobotUserRelation;

@Repository
public class RobotUserRelationDao extends BaseDao implements IRobotUserRelationDao {
	@Override
	public Long bindRobot(RobotUserRelation robotUserRelation) {
		return (Long) getSqlMapClientTemplate().insert("robot_user_relation.bindRobot", robotUserRelation);
	}

	@Override
	public List<RobotUserRelation> queryForBindedRobot(Long userId) {
		return (List<RobotUserRelation>) getSqlMapClientTemplate().queryForList("robot_user_relation.queryForBindedRobot", userId);
	}

	@Override
	public RobotUserRelation queryForRobotByUuid(String uuid) {
		return (RobotUserRelation) getSqlMapClientTemplate().queryForObject("robot_user_relation.queryForRobotByUuid", uuid);
	}
}
