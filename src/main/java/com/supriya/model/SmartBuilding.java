package com.supriya.model;

public class SmartBuilding  extends ResponseUtil {

	private long buildingSensorDetailId;
	private long buildingFloorNumber;
	private long buildingRoomNumber;
	private String sensorDeviceId;
	private String sensorType;
	private String sensorKey;
	private String sensorValue;
	private long  recordCreateTimestamp;
	private String  referenceImagePath;
	private String delInd;
	public long getBuildingSensorDetailId() {
		return buildingSensorDetailId;
	}
	public void setBuildingSensorDetailId(long buildingSensorDetailId) {
		this.buildingSensorDetailId = buildingSensorDetailId;
	}
	public long getBuildingFloorNumber() {
		return buildingFloorNumber;
	}
	public void setBuildingFloorNumber(long buildingFloorNumber) {
		this.buildingFloorNumber = buildingFloorNumber;
	}
	public long getBuildingRoomNumber() {
		return buildingRoomNumber;
	}
	public void setBuildingRoomNumber(long buildingRoomNumber) {
		this.buildingRoomNumber = buildingRoomNumber;
	}
	public String getSensorDeviceId() {
		return sensorDeviceId;
	}
	public void setSensorDeviceId(String sensorDeviceId) {
		this.sensorDeviceId = sensorDeviceId;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	public String getSensorKey() {
		return sensorKey;
	}
	public void setSensorKey(String sensorKey) {
		this.sensorKey = sensorKey;
	}
	public String getSensorValue() {
		return sensorValue;
	}
	public void setSensorValue(String sensorValue) {
		this.sensorValue = sensorValue;
	}
	public long getRecordCreateTimestamp() {
		return recordCreateTimestamp;
	}
	public void setRecordCreateTimestamp(long recordCreateTimestamp) {
		this.recordCreateTimestamp = recordCreateTimestamp;
	}
	public String getReferenceImagePath() {
		return referenceImagePath;
	}
	public void setReferenceImagePath(String referenceImagePath) {
		this.referenceImagePath = referenceImagePath;
	}
	public String getDelInd() {
		return delInd;
	}
	public void setDelInd(String delInd) {
		this.delInd = delInd;
	}
	
	
	
}
