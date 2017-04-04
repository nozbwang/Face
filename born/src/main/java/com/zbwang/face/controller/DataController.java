package com.zbwang.face.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zbwang.face.constant.Constants;
import com.zbwang.face.domain.RobotControl;
import com.zbwang.face.domain.RobotMotion;
import com.zbwang.face.domain.RobotOnlineData;
import com.zbwang.face.domain.RobotTemperature;
import com.zbwang.face.domain.RobotUserRelation;
import com.zbwang.face.dto.RobotMotionCommand;
import com.zbwang.face.dto.RobotOnlineDataCommand;
import com.zbwang.face.dto.RobotTemperatureCommand;
import com.zbwang.face.service.impl.RobotService;
import com.zbwang.face.util.FormatUtil;

@Controller
public class DataController extends BaseController {
	@Autowired
	private RobotService robotService;

	@RequestMapping("/upload/onlineData")
	public void collectOnlineData(RobotOnlineDataCommand onlineDataCommand, HttpServletResponse response) throws IOException {
		String uuid = onlineDataCommand.getUuid();
		RobotUserRelation robot = robotService.getRobotByUuid(uuid);
		if (robot == null) {
			return;
		}
		RobotOnlineData robotOnlineData = new RobotOnlineData();
		robotOnlineData.setUuid(uuid);
		robotOnlineData.setVoltage(onlineDataCommand.getVoltage());
		robotOnlineData.setCurrent(onlineDataCommand.getCurrent());
		robotOnlineData.setPostionX(onlineDataCommand.getPostionX());
		robotOnlineData.setPostionY(onlineDataCommand.getPostionY());
		robotOnlineData.setMode(onlineDataCommand.getMode());
		robotOnlineData.setAlarmStatus(onlineDataCommand.getAlarmStatus());
		robotOnlineData.setCollectTime(FormatUtil.getCollectTime((onlineDataCommand.getCollectTime())));
		robotService.uploadOnlineData(robotOnlineData);
		writeSuccessData(response);
	}

	@RequestMapping("/upload/motion")
	public void collectMotion(RobotMotionCommand motionCommand, HttpServletResponse response) throws IOException {
		String uuid = motionCommand.getUuid();
		RobotUserRelation robot = robotService.getRobotByUuid(uuid);
		if (robot == null) {
			return;
		}
		RobotMotion robotMotion = new RobotMotion();
		robotMotion.setUuid(uuid);
		robotMotion.setSpeed(motionCommand.getSpeed());
		robotMotion.setEnergy(motionCommand.getEnergy());
		robotMotion.setHeartRateWired(motionCommand.getHeartRateWired());
		robotMotion.setHeartRateWireless(motionCommand.getHeartRateWireless());
		robotMotion.setPower(motionCommand.getPower());
		robotMotion.setStatus(motionCommand.getStatus());
		robotMotion.setCollectTime(FormatUtil.getCollectTime((motionCommand.getCollectTime())));
		robotService.uploadRobotMotion(robotMotion);
		writeSuccessData(response);
	}

	@RequestMapping("/upload/sensor")
	public void collectTemperature(RobotTemperatureCommand temperatureCommand, HttpServletResponse response) throws IOException {
		String uuid = temperatureCommand.getUuid();
		RobotUserRelation robot = robotService.getRobotByUuid(uuid);
		if (robot == null) {
			return;
		}
		RobotTemperature robotTemperature = new RobotTemperature();
		robotTemperature.setUuid(uuid);
		robotTemperature.setTemperature(temperatureCommand.getTemperature());
		robotTemperature.setCollectTime(FormatUtil.getCollectTime((temperatureCommand.getCollectTime())));
		robotService.uploadRobotTemperature(robotTemperature);
		writeSuccessData(response);
	}

	@RequestMapping("/robot/status")
	public void getRobotStatus(HttpServletResponse response, @RequestParam String uuid) throws IOException {
		List<RobotControl> robotControls = robotService.getRobotControlSignal(uuid);
		Map<String, Object> map = Maps.newHashMap();
		if (CollectionUtils.isNotEmpty(robotControls)) {
			List<Long> robotControlIds = Lists.newArrayList();
			for (RobotControl robotControl : robotControls) {
				robotControlIds.add(robotControl.getRecId());
			}
			robotService.disableControlSignal(robotControlIds);
			map.put("command1", String.valueOf(robotControls.get(0).getAction()));
		} else {
			map.put("command1", Constants.ACTION_KEEP);
		}
		map.put("command2", "");
		writeSuccessData(response, map);
	}

	@RequestMapping("/upload/robotStatus")
	public void getRobotStatus(HttpServletResponse response, @RequestParam String uuid, @RequestParam String status) throws IOException {
		robotService.uploadRobotStatus(uuid, status);
		writeSuccessData(response, "status", status);
	}
}
