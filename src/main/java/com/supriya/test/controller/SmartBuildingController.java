package com.supriya.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supriya.model.SmartBuilding;
import com.supriya.service.SmartBuildingServiceImpl;
@CrossOrigin
@RestController
public class SmartBuildingController {

	@Autowired
	SmartBuildingServiceImpl  smartBuildingService;
	
	
	@PostMapping("/addSensorData")
	public Map<String, Object> addSensorData(@RequestBody  SmartBuilding   building) {
		 Map<String, Object> result = new HashMap<>();
		 System.out.println("Request for /addSensorData");
		 result= smartBuildingService.addBuildingSensorData(building);
		return result;
	}
	
	
	@PostMapping("/updateSensorData")	
public Map<String, Object> updateSensorData(@RequestBody  SmartBuilding   building) {
		 Map<String, Object> result = new HashMap<>();
		 System.out.println("Request for /updateSensorData");
			result=smartBuildingService.updateBuildingSensorData(building);
			return result;
	}

	
	@PostMapping("/findSensorData")
public Map<String, Object> findSensorData(@RequestBody  SmartBuilding   building) {
		 Map<String, Object> result = new HashMap<>();
		 System.out.println("Request for /findSensorData");
			result = smartBuildingService.findBuildingSensorData(building);
			return result;
}

	
	@PostMapping("/findAllSensorData")
	public Map<String, Object>  findAllSensorData(@RequestBody  SmartBuilding   building) {
		 Map<String, Object> result = new HashMap<>();
		 System.out.println("Request for /findAllSensorData");
			result = smartBuildingService.findAllBuildingSensorData(building);
			return result;
}

}
