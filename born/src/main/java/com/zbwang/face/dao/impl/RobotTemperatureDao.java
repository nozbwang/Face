package com.zbwang.face.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.IRobotTemperatureDao;
import com.zbwang.face.domain.RobotTemperature;

@Repository
public class RobotTemperatureDao extends BaseDao implements IRobotTemperatureDao {
	@Override
	public void uploadRobotTemperature(RobotTemperature robotTemperature) {
		getSqlMapClientTemplate().insert("robot_temperature.uploadRobotTemperature", robotTemperature);
	}

	@Override
	public List<RobotTemperature> queryForRobotTemperature(Long robotId) {
		return getSqlMapClientTemplate().queryForList("robot_temperature.queryForRobotTemperature", robotId);
	}
}
