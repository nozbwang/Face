package com.zbwang.face.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.dao.IRobotControlDao;
import com.zbwang.face.dao.IRobotMotionDao;
import com.zbwang.face.dao.IRobotOnlineDataDao;
import com.zbwang.face.dao.IRobotTemperatureDao;
import com.zbwang.face.dao.IRobotUserRelationDao;
import com.zbwang.face.dao.impl.RobotDao;
import com.zbwang.face.domain.Robot;
import com.zbwang.face.domain.RobotControl;
import com.zbwang.face.domain.RobotMotion;
import com.zbwang.face.domain.RobotOnlineData;
import com.zbwang.face.domain.RobotTemperature;
import com.zbwang.face.domain.RobotUserRelation;
import com.zbwang.face.service.IRobotService;

@Service
public class RobotService implements IRobotService {
	@Autowired
	private RobotDao robotDao;
	@Autowired
	private IRobotUserRelationDao robotUserRelationDao;
	@Autowired
	private IRobotOnlineDataDao robotOnlineDataDao;
	@Autowired
	private IRobotMotionDao robotMotionDao;
	@Autowired
	private IRobotControlDao robotControlDao;
	@Autowired
	private IRobotTemperatureDao robotTemperatureDao;

	@Override
	public Long insertRobot(Robot robot) {
		return robotDao.insertRobot(robot);
	}

	@Override
	public Long bindRobot(RobotUserRelation robotUserRelation) {
		return robotUserRelationDao.bindRobot(robotUserRelation);
	}

	@Override
	public void uploadOnlineData(RobotOnlineData robotOnlineData) {
		robotOnlineDataDao.uploadOnlineData(robotOnlineData);
	}

	@Override
	public void uploadRobotMotion(RobotMotion robotMotion) {
		robotMotionDao.uploadRobotMotion(robotMotion);
	}

	@Override
	public List<RobotMotion> getRobotMotion(Long robotId) {
		return robotMotionDao.queryForRobotMotion(robotId);
	}

	@Override
	public void uploadRobotTemperature(RobotTemperature robotTemperature) {
		robotTemperatureDao.uploadRobotTemperature(robotTemperature);
	}

	@Override
	public List<RobotTemperature> getRobotTemperature(Long robotId) {
		return robotTemperatureDao.queryForRobotTemperature(robotId);
	}

	@Override
	public void insertRobotControl(RobotControl robotControl) {
		robotControlDao.insertRobotControl(robotControl);
	}

	@Override
	public List<RobotControl> getRobotControl(Long robotId) {
		return robotControlDao.queryForRobotControl(robotId);
	}

	@Override
	public List<RobotUserRelation> getBindedRobot(Long userId) {
		return robotUserRelationDao.queryForBindedRobot(userId);
	}

	@Override
	public RobotUserRelation getRobotByUuid(String uuid) {
		if (StringUtils.isBlank(uuid)) {
			return null;
		}
		return robotUserRelationDao.queryForRobotByUuid(uuid);
	}

	@Override
	public List<RobotControl> getRobotControlSignal(String uuid) {
		RobotUserRelation robotUserRelation = getRobotByUuid(uuid);
		if (robotUserRelation != null) {
			return robotControlDao.queryForRobotControlSignal(robotUserRelation.getRobotId());
		}
		return null;
	}

	@Override
	public void disableControlSignal(List<Long> robotControlIds) {
		robotControlDao.disableControlSignal(robotControlIds);
	}

	@Override
	public List<RobotOnlineData> getRobotOnlineData(Long robotId) {
		return robotOnlineDataDao.queryForRobotOnlineData(robotId);
	}

	@Override
	public void uploadRobotStatus(String uuid, String status) {
		robotDao.uploadRobotStatus(uuid, status);
	}
}