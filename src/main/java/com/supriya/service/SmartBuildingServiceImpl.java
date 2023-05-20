package com.supriya.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supriya.dao.SmartBuildingDAO;
import com.supriya.dao.SmartBuildingDAOImpl;
import com.supriya.model.SmartBuilding;



public class SmartBuildingServiceImpl implements SmartBuildingService{

	
	@Autowired
	SmartBuildingDAOImpl   smartBuildingDAO;
	
	@Override
	public Map<String, Object> addBuildingSensorData(SmartBuilding building) {
		return smartBuildingDAO.addBuildingSensorData(building);
	}

	@Override
	public Map<String, Object> updateBuildingSensorData(SmartBuilding building) {
		// TODO Auto-generated method stub
		return smartBuildingDAO.updateBuildingSensorData(building) ;
	}

	@Override
	public Map<String, Object> deleteBuildingSensorData(SmartBuilding building) {
		return smartBuildingDAO.deleteBuildingSensorData(building) ;
	}

	@Override
	public Map<String, Object> findBuildingSensorData(SmartBuilding building) {
		return smartBuildingDAO.findBuildingSensorData(building);
	}

	@Override
	public Map<String, Object> findAllBuildingSensorData(SmartBuilding building) {
		return smartBuildingDAO.findAllBuildingSensorData(building);
	}

}
