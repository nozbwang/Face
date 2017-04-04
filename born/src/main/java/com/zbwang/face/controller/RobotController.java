package com.zbwang.face.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
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
import com.zbwang.face.dto.Page;
import com.zbwang.face.service.IRobotService;

@Controller
public class RobotController extends BaseController {
	@Autowired
	private IRobotService robotService;

	@RequestMapping("/bind/equipment")
	public ModelAndView toBindRobot() {
		return getModelAndView("robotType", Constants.TYPE_ROBOT, "robot/bindEquipment");
	}

	@RequestMapping("/bind")
	public String bind(Robot robot, HttpServletRequest request) {
		User user = getUser();
		if (!user.isLogon()) {
			return getRedirectView("user/login");
		}
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
		return getRedirectView("robot");
	}

	@RequestMapping("/robot")
	public ModelAndView showRobot() {
		User user = getUser();
		if (!user.isLogon()) {
			return getBaseModelAndView(getRedirectView("user/login"));
		}
		List<RobotUserRelation> bindedRobots = robotService.getBindedRobot(user.getUserId());
		if (CollectionUtils.isNotEmpty(bindedRobots)) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("bindedRobots", bindedRobots);
			return getBaseModelAndView(map, "robot/show");
		}
		return getBaseModelAndView("robot/show");
	}

	@RequestMapping("/detail/robot")
	public ModelAndView showRobotDetail(HttpServletRequest request, @RequestParam String uuid) {
		int currentPage = NumberUtils.toInt(request.getParameter("page"), 1);
		int startIndex = (currentPage - 1) * 10 + 1;
		List<RobotOnlineData> robotOnlineData = robotService.getRobotOnlineData(uuid, startIndex);
		int total = robotService.countRobotOnlineData(uuid);
		Map<String, Object> map = Maps.newHashMap();
		map.put("robotOnlineData", robotOnlineData);
		Page page = new Page(total, 10, currentPage, "/detail/robot?uuid=" + uuid);
		map.put("page", page);
		return getBaseModelAndView(map, "robot/showRobot");
	}

	@RequestMapping("/detail/motionEquipment")
	public ModelAndView showMotionDetail(HttpServletRequest request, @RequestParam String uuid) {
		int currentPage = NumberUtils.toInt(request.getParameter("page"), 1);
		int startIndex = (currentPage - 1) * 10 + 1;
		List<RobotMotion> robotMotion = robotService.getRobotMotion(uuid, startIndex);
		int total = robotService.countRobotMotion(uuid);
		Map<String, Object> map = Maps.newHashMap();
		map.put("robotMotion", robotMotion);
		Page page = new Page(total, 10, currentPage, "/detail/robot?uuid=" + uuid);
		map.put("page", page);
		return getBaseModelAndView(map, "robot/showMotion");
	}

	@RequestMapping("/detail/temperature")
	public ModelAndView showTemperatureDetail(HttpServletRequest request, @RequestParam String uuid) {
		int currentPage = NumberUtils.toInt(request.getParameter("page"), 1);
		int startIndex = (currentPage - 1) * 10 + 1;
		List<RobotTemperature> robotTemperature = robotService.getRobotTemperature(uuid, startIndex);
		int total = robotService.countRobotMotion(uuid);
		Map<String, Object> map = Maps.newHashMap();
		map.put("robotTemperature", robotTemperature);
		Page page = new Page(total, 10, currentPage, "/detail/robot?uuid=" + uuid);
		map.put("page", page);
		return getBaseModelAndView(map, "robot/showTemperature");
	}

	@RequestMapping("/showControl")
	public ModelAndView showControl(@RequestParam String uuid) {
		RobotUserRelation bindedRobot = robotService.getRobotByUuid(uuid);
		List<RobotControl> robotControls = robotService.getRobotControl(uuid);
		Map<String, Object> map = Maps.newHashMap();
		map.put("bindedRobot", bindedRobot);
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
		return getRedirectView("showControl?uuid=" + robotControl.getUuid());
	}

	@RequestMapping("/stop")
	public String stopRobot(RobotControl robotControl) {
		User user = getUser();
		if (user.isLogon()) {
			robotControl.setAction(Constants.ACTION_STOP);
			robotControl.setUserId(user.getUserId());
			robotService.insertRobotControl(robotControl);
		}
		return getRedirectView("showControl?uuid=" + robotControl.getUuid());
	}
}
