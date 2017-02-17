package com.zbwang.face.service;

import java.util.List;

import com.zbwang.face.domain.Robot;
import com.zbwang.face.domain.RobotControl;
import com.zbwang.face.domain.RobotMotion;
import com.zbwang.face.domain.RobotOnlineData;
import com.zbwang.face.domain.RobotTemperature;
import com.zbwang.face.domain.RobotUserRelation;

public interface IRobotService {
	Long insertRobot(Robot robot);

	Long bindRobot(RobotUserRelation robotUserRelation);

	List<RobotUserRelation> getBindedRobot(Long userId);

	RobotUserRelation getRobotByUuid(String uuid);

	void uploadOnlineData(RobotOnlineData robotOnlineData);

	List<RobotOnlineData> getRobotOnlineData(Long robotId);

	void uploadRobotMotion(RobotMotion robotMotion);

	List<RobotMotion> getRobotMotion(Long robotId);

	void uploadRobotTemperature(RobotTemperature robotTemperature);

	List<RobotTemperature> getRobotTemperature(Long robotId);

	void insertRobotControl(RobotControl robotControl);

	List<RobotControl> getRobotControl(Long robotId);

	List<RobotControl> getRobotControlSignal(String uuid);

	void disableControlSignal(List<Long> robotControlIds);

	void uploadRobotStatus(String uuid, String status);
}
