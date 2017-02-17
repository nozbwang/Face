package com.zbwang.face.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.IRobotOnlineDataDao;
import com.zbwang.face.domain.RobotOnlineData;

@Repository
public class RobotOnlineDataDao extends BaseDao implements IRobotOnlineDataDao {
	@Override
	public void uploadOnlineData(RobotOnlineData robotOnlineData) {
		getSqlMapClientTemplate().insert("robot_online_data.uplodaOnlineData", robotOnlineData);
	}

	@Override
	public List<RobotOnlineData> queryForRobotOnlineData(Long robotId) {
		return getSqlMapClientTemplate().queryForList("robot_online_data.queryForRobotOnlineData", robotId);
	}
}
