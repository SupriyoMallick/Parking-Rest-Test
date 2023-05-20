package com.supriya.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.supriya.model.SmartBuilding;

@Component
public interface SmartBuildingService {

	public Map<String, Object> addBuildingSensorData(SmartBuilding building );
	public Map<String, Object> updateBuildingSensorData(SmartBuilding building );
	public Map<String, Object> deleteBuildingSensorData(SmartBuilding building );
	public Map<String, Object> findBuildingSensorData(SmartBuilding building );
	public Map<String, Object> findAllBuildingSensorData(SmartBuilding building );
	
	
}
