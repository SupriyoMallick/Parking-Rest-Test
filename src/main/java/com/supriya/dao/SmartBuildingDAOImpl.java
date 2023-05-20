package com.supriya.dao;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.supriya.model.SmartBuilding;

@Component
public class SmartBuildingDAOImpl implements SmartBuildingDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	@Override
	public Map<String, Object> addBuildingSensorData(SmartBuilding building) {
		Map<String, Object> response = new HashMap<>();
		try {
			int row = jdbcTemplate.update("INSERT INTO smart_building_sensor_details (	building_floor, building_room, sensor_device_id, sensor_type, sensor_key, sensor_value, rcd_crt_timestamp, ref_img_data_path, del_ind) VALUES ("
					+ ""+building.getBuildingFloorNumber() +","+building.getBuildingRoomNumber() +",'"+building.getSensorDeviceId()+"','"+building.getSensorType()+"','"+building.getSensorKey()+"','"+building.getSensorValue()+"',"+building.getRecordCreateTimestamp()+",'"+building.getReferenceImagePath()+"','"+building.getDelInd()+"')");
			if(row>0) {
				building.setStatus("Successful");
				response.put("addBuildingSensorDataResponse", building);
				
			}else {
				building.setStatus("Fail");
				building.setErrorMsg("No data added");
				response.put("addBuildingSensorDataResponse", building);
			}
			}catch(Exception e ) 
			{
				building.setStatus("Fail");
				building.setErrorMsg(e.getMessage());
				response.put("addBuildingSensorDataResponse", building);
				
			}
		System.out.println("Response Payload : "+response);
		return response;
	}

	@Override
	public Map<String, Object> updateBuildingSensorData(SmartBuilding building) {
		Map<String, Object> response = new HashMap<>();
		try {
			int row = jdbcTemplate.update("update public.smart_building_sensor_details "
					+ "set sensor_value = '"+building.getSensorValue()+"' , rcd_crt_timestamp = "+building.getRecordCreateTimestamp()+" "
					+" where sensor_device_id = '"+building.getSensorDeviceId()+"' and sensor_key ='" +building.getSensorKey()+"' ");
			if(row>0) {
				building.setStatus("Update Successful");
				response.put("updateBuildingSensorDataResponse", building);
				
			}else {
				building.setStatus("Update Fail. Condition not satisfied.");
				building.setErrorMsg("No data updated");
				response.put("updateBuildingSensorDataResponse", building);
			}
			}catch(Exception e ) 
			{
				building.setStatus("Update Fail DB Exception");
				building.setErrorMsg(e.getMessage());
				response.put("updateBuildingSensorDataResponse", building);
				
			}
		System.out.println("Response Payload : "+response);
		return response;
	}

	@Override
	public Map<String, Object> deleteBuildingSensorData(SmartBuilding building) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findBuildingSensorData(SmartBuilding building) {
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		try {
		result = jdbcTemplate.queryForMap("SELECT building_sensor_dtl_id, building_floor, building_room, sensor_device_id, sensor_type, sensor_key, sensor_value, rcd_crt_timestamp, ref_img_data_path, del_ind "
				+ "	FROM public.smart_building_sensor_details where sensor_device_id='"+building.getSensorDeviceId()+"' and sensor_key ='"+building.getSensorKey()+"' order by rcd_crt_timestamp desc limit 1");
		response.put("status", "Successful");
		response.put("errorMsg", "");
		response.put("findBuildingSensorDataResponse", result);
		}catch(Exception e){
			response.put("status", "No Data Found");
			response.put("errorMsg", e.getMessage());
			response.put("findBuildingSensorDataResponse", "");
		}
		System.out.println("Response Payload : "+response);
		return response;
	}

	@Override
	@CrossOrigin
	public Map<String, Object> findAllBuildingSensorData(SmartBuilding building) {
		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		
		try {
			result = jdbcTemplate.queryForList("SELECT building_sensor_dtl_id, building_floor, building_room, sensor_device_id, sensor_type, sensor_key, sensor_value, rcd_crt_timestamp, ref_img_data_path, del_ind "
		
				+ "	FROM public.smart_building_sensor_details where sensor_device_id='"+building.getSensorDeviceId()+"' order by rcd_crt_timestamp desc , building_sensor_dtl_id asc");
			response.put("status", "Successful");
			response.put("errorMsg", "");
			int tot_occ=0;
			int tot_vac=0;
			long epocDtm=0;
			
			for(Map<String, Object> a : result) {
				if(Double.valueOf( a.get("sensor_value").toString())>Double.valueOf("5.00")) {
					a.put("parking_slot_status", "Vacant");
					tot_vac++;
				}else {
					a.put("parking_slot_status", "Occupied");
					tot_occ++;
				}
				a.put("parking_slot_num", (a.get("sensor_key").toString()).charAt( (a.get("sensor_key").toString()).length()-1 ));
				epocDtm= Long.valueOf(a.get("rcd_crt_timestamp").toString());
			}
			response.put("findAllBuildingSensorDataResponse", result);
			response.put("tot_occ", tot_occ);
			response.put("tot_vac", tot_vac);
			 ZoneId zoneid1 = ZoneId.of("Asia/Kolkata");  
			response.put("last_update", "Today "+LocalTime.now(zoneid1).toString() );
			}catch(Exception e){
				response.put("status", "No Data Found");
				response.put("errorMsg", e.getMessage());
				response.put("findAllBuildingSensorDataResponse", "");
			}
		System.out.println("Response Payload : "+response);
			return response;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
		
	}

}
