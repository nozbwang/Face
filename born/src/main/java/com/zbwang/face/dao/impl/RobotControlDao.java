package com.zbwang.face.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.zbwang.face.dao.IRobotControlDao;
import com.zbwang.face.domain.RobotControl;

@Repository
public class RobotControlDao extends BaseDao implements IRobotControlDao {
	@Override
	public void insertRobotControl(RobotControl robotControl) {
		getSqlMapClientTemplate().insert("robot_control.insertRobotControl", robotControl);
	}

	@Override
	public List<RobotControl> queryForRobotControl(Long robotId) {
		return getSqlMapClientTemplate().queryForList("robot_control.queryForRobotControl", robotId);
	}

	@Override
	public List<RobotControl> queryForRobotControlSignal(Long robotId) {
		return (List<RobotControl>) getSqlMapClientTemplate().queryForList("robot_control.queryForRobotControlSignal", robotId);
	}

	@Override
	public void disableControlSignal(List<Long> robotControlIds) {
		Map map = Maps.newHashMap();
		map.put("robotControlIds", robotControlIds);
		getSqlMapClientTemplate().update("robot_control.disableControlSignal", map);
	}
}
