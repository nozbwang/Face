package com.zbwang.face.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.zbwang.face.dao.IRobotMotionDao;
import com.zbwang.face.domain.RobotMotion;

@Repository
public class RobotMotionDao extends BaseDao implements IRobotMotionDao {
	@Override
	public void uploadRobotMotion(RobotMotion robotMotion) {
		getSqlMapClientTemplate().insert("robot_motion.uplodaRobotMotion", robotMotion);
	}

	@Override
	public List<RobotMotion> queryForRobotMotion(String uuid, int startIndex) {
		Map<String, Object> paramMap = Maps.newHashMap();
		paramMap.put("uuid", uuid);
		paramMap.put("startIndex", startIndex);
		return getSqlMapClientTemplate().queryForList("robot_motion.queryForRobotMotion", paramMap);
	}

	@Override
	public int countRobotMotion(String uuid) {
		return (int) getSqlMapClientTemplate().queryForObject("robot_motion.countRobotMotion", uuid);
	}
}
