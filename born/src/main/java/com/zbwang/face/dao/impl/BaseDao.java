package com.zbwang.face.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zbwang.face.domain.RobotUserRelation;

public class BaseDao extends SqlMapClientDaoSupport {
	@Autowired
	public void setSqlmapClient(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}

	public Long bindRobot(RobotUserRelation robot) {
		return null;
	}
}
