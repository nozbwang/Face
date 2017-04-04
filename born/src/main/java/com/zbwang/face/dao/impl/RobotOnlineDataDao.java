package com.zbwang.face.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.zbwang.face.dao.IRobotOnlineDataDao;
import com.zbwang.face.domain.RobotOnlineData;

@Repository
public class RobotOnlineDataDao extends BaseDao implements IRobotOnlineDataDao {
	@Override
	public void uploadOnlineData(RobotOnlineData robotOnlineData) {
		getSqlMapClientTemplate().insert("robot_online_data.uplodaOnlineData", robotOnlineData);
	}

	@Override
	public List<RobotOnlineData> queryForRobotOnlineData(String uuid, int startIndex) {
		Map<String, Object> paramMap = Maps.newHashMap();
		paramMap.put("uuid", uuid);
		paramMap.put("startIndex", startIndex);
		return getSqlMapClientTemplate().queryForList("robot_online_data.queryForRobotOnlineData", paramMap);
	}

	@Override
	public int countRobotOnlineData(String uuid) {
		return (int) getSqlMapClientTemplate().queryForObject("robot_online_data.countRobotOnlineData", uuid);
	}
}
