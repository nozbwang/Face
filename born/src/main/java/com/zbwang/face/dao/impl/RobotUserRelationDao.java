package com.zbwang.face.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.zbwang.face.dao.IRobotUserRelationDao;
import com.zbwang.face.domain.RobotUserRelation;

@Repository
public class RobotUserRelationDao extends BaseDao implements IRobotUserRelationDao {
	@Override
	public Long bindRobot(RobotUserRelation robotUserRelation) {
		return (Long) getSqlMapClientTemplate().insert("robot_user_relation.bindRobot", robotUserRelation);
	}

	@Override
	public void deleteRobot(String uuid, Long userId) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("userId", userId);
		map.put("uuid", uuid);
		getSqlMapClientTemplate().update("robot_user_relation.deleteRobot", map);
	}

	@Override
	public List<RobotUserRelation> queryForBindedRobot(Long userId, Short robotType) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("userId", userId);
		map.put("robotType", robotType);
		return (List<RobotUserRelation>) getSqlMapClientTemplate().queryForList("robot_user_relation.queryForBindedRobot", map);
	}

	@Override
	public List<RobotUserRelation> queryForBindedRobot(Long userId) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("userId", userId);
		return (List<RobotUserRelation>) getSqlMapClientTemplate().queryForList("robot_user_relation.queryForBindedRobot", map);
	}

	@Override
	public RobotUserRelation queryForRobotByUuid(String uuid) {
		return (RobotUserRelation) getSqlMapClientTemplate().queryForObject("robot_user_relation.queryForRobotByUuid", uuid);
	}
}
