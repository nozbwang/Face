package com.zbwang.face.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.zbwang.face.dao.IRobotTemperatureDao;
import com.zbwang.face.domain.RobotTemperature;

@Repository
public class RobotTemperatureDao extends BaseDao implements IRobotTemperatureDao {
	@Override
	public void uploadRobotTemperature(RobotTemperature robotTemperature) {
		getSqlMapClientTemplate().insert("robot_temperature.uploadRobotTemperature", robotTemperature);
	}

	@Override
	public List<RobotTemperature> queryForRobotTemperature(String uuid, int startIndex) {
		Map<String, Object> paramMap = Maps.newHashMap();
		paramMap.put("uuid", uuid);
		paramMap.put("startIndex", startIndex);
		return getSqlMapClientTemplate().queryForList("robot_temperature.queryForRobotTemperature", paramMap);
	}

	@Override
	public int countTemperature(String uuid) {
		return (int) getSqlMapClientTemplate().queryForObject("robot_temperature.countTemperature", uuid);
	}
}
