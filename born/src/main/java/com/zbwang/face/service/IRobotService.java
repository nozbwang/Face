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

	void deleteRobot(String uuid, Long userId);

	RobotUserRelation getRobotByUuid(String uuid);

	void uploadOnlineData(RobotOnlineData robotOnlineData);

	void uploadRobotMotion(RobotMotion robotMotion);

	List<RobotMotion> getRobotMotion(String uuid, int startIndex);

	void uploadRobotTemperature(RobotTemperature robotTemperature);

	List<RobotTemperature> getRobotTemperature(String uuid, int startIndex);

	void insertRobotControl(RobotControl robotControl);

	void disableControlSignal(List<Long> robotControlIds);

	void uploadRobotStatus(String uuid, String status);

	RobotUserRelation getBindedRobot(Long userId, Short robotType);

	List<RobotUserRelation> getBindedRobot(Long userId);

	List<RobotOnlineData> getRobotOnlineData(String uuid, int startIndex);

	List<RobotOnlineData> getRobotOnlineData(String uuid, int startIndex, String startTime, String endTime);

	List<RobotControl> getRobotControl(String uuid);

	List<RobotControl> getRobotControlSignal(String uuid);

	int countRobotMotion(String uuid);

	int countTemperature(String uuid);

	int countRobotOnlineData(String uuid, String startTime, String endTime);
}
