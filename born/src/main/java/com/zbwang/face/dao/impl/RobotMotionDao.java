package com.zbwang.face.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.IRobotMotionDao;
import com.zbwang.face.domain.RobotMotion;

@Repository
public class RobotMotionDao extends BaseDao implements IRobotMotionDao {
	@Override
	public void uploadRobotMotion(RobotMotion robotMotion) {
		getSqlMapClientTemplate().insert("robot_motion.uplodaRobotMotion", robotMotion);
	}

	@Override
	public List<RobotMotion> queryForRobotMotion(Long robotId) {
		return getSqlMapClientTemplate().queryForList("robot_motion.queryForRobotMotion", robotId);
	}
}
