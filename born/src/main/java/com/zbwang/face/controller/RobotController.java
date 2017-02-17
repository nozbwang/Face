package com.zbwang.face.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.zbwang.face.constant.Constants;
import com.zbwang.face.domain.Robot;
import com.zbwang.face.domain.RobotControl;
import com.zbwang.face.domain.RobotMotion;
import com.zbwang.face.domain.RobotOnlineData;
import com.zbwang.face.domain.RobotTemperature;
import com.zbwang.face.domain.RobotUserRelation;
import com.zbwang.face.domain.User;
import com.zbwang.face.service.IRobotService;

@Controller
@RequestMapping("/robot")
public class RobotController extends BaseController {
	@Autowired
	private IRobotService robotService;

	@RequestMapping("/show")
	public ModelAndView showRobot() {
		User user = getUser();
		List<RobotUserRelation> bindedRobot = robotService.getBindedRobot(user.getUserId());
		Map<String, Object> map = Maps.newHashMap();
		map.put("bindedRobot", bindedRobot);
		return getBaseModelAndView(map, "robot/show");
	}

	@RequestMapping("/bind")
	public ModelAndView toBindRobot() {
		return getBaseModelAndView("robot/bind");
	}

	@RequestMapping("/bindRobot")
	public String bindRobot(Robot robot) {
		User user = getUser();
		if (user.isLogon()) {
			robot.setAdder(user.getUserName());
			robot.setUpdater(user.getUserName());
			robot.setAdderId(user.getUserId());
			robot.setUpdaterId(user.getUserId());
			robot.setStatus(Constants.STATUS_STOP);
			Long robotId = robotService.insertRobot(robot);
			RobotUserRelation robotUserRelation = new RobotUserRelation();
			robotUserRelation.setRobotId(robotId);
			robotUserRelation.setUserId(user.getUserId());
			robotUserRelation.setUuid(robot.getUuid());
			robotUserRelation.setStatus(Constants.STATUS_BIND);
			robotService.bindRobot(robotUserRelation);
		}
		return getRedirectView("robot/show");
	}

	@RequestMapping("/showOnlineData")
	public ModelAndView showOnlineData(@RequestParam String robotId) {
		List<RobotOnlineData> robotOnlineData = robotService.getRobotOnlineData(NumberUtils.toLong(robotId));
		Map<String, Object> map = Maps.newHashMap();
		map.put("robotOnlineData", robotOnlineData);
		return getBaseModelAndView(map, "robot/showOnlineData");
	}

	@RequestMapping("/showMotion")
	public ModelAndView showMotion(@RequestParam String robotId) {
		List<RobotMotion> robotMotion = robotService.getRobotMotion(NumberUtils.toLong(robotId));
		Map<String, Object> map = Maps.newHashMap();
		map.put("robotMotion", robotMotion);
		return getBaseModelAndView(map, "robot/showMotion");
	}

	@RequestMapping("/showTemperature")
	public ModelAndView showTemperature(@RequestParam String robotId) {
		List<RobotTemperature> robotTemperature = robotService.getRobotTemperature(NumberUtils.toLong(robotId));
		Map<String, Object> map = Maps.newHashMap();
		map.put("robotTemperature", robotTemperature);
		return getBaseModelAndView(map, "robot/showTemperature");
	}

	@RequestMapping("/showControl")
	public ModelAndView showControl(@RequestParam String robotId) {
		List<RobotControl> robotControls = robotService.getRobotControl(NumberUtils.toLong(robotId));
		Map<String, Object> map = Maps.newHashMap();
		map.put("robotControls", robotControls);
		return getBaseModelAndView(map, "robot/showControl");
	}

	@RequestMapping("/start")
	public String startlRobot(RobotControl robotControl) {
		User user = getUser();
		if (user.isLogon()) {
			robotControl.setAction(Constants.ACTION_START);
			robotControl.setUserId(user.getUserId());
			robotService.insertRobotControl(robotControl);
		}
		return getRedirectView("robot/showControl?robotId=" + robotControl.getRobotId());
	}

	@RequestMapping("/stop")
	public String stopRobot(RobotControl robotControl) {
		User user = getUser();
		if (user.isLogon()) {
			robotControl.setAction(Constants.ACTION_STOP);
			robotControl.setUserId(user.getUserId());
			robotService.insertRobotControl(robotControl);
		}
		return getRedirectView("robot/showControl?robotId=" + robotControl.getRobotId());
	}
}
