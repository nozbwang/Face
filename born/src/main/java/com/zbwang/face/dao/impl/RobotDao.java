package com.zbwang.face.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.zbwang.face.dao.IRobotDao;
import com.zbwang.face.domain.Robot;

@Repository
public class RobotDao extends BaseDao implements IRobotDao {
	@Override
	public Long insertRobot(Robot robot) {
		return (Long) getSqlMapClientTemplate().insert("robot.insertRobot", robot);
	}

	@Override
	public Integer uploadRobotStatus(String uuid, String status) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("uuid", uuid);
		map.put("status", status);
		return getSqlMapClientTemplate().update("robot.uploadRobotStatus", map);
	}
}
