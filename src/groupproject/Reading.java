package groupproject;

import java.sql.Date;

public class Reading {

	private String patientID;
	private String clinic;
	private String rType;
	private String rId;
	private String rValue;
	private Date rDate;

	public Reading(String patientID, String clinic, String type, String id, String value, Date date) {


		setClinic(clinic);
		setPatientID(patientID);
		setRType(type);
		setRId(id);
		setRValue(value);
		setRDate(date);
	}

	/*
	 * accepts date as a String of the millisecond time value instead of an already
	 * instantiated Date Object.
	 */
	public Reading(String type, String id, String value, String date) {

		setRType(type);
		setRId(id);
		setRValue(value);
		setRDate(date);
	}

	// =================================setters===================

	public void setClinic(String clinic){
		this.clinic = clinic;
	}

	public void setPatientID(String id) {
		patientID = id;
	}

	public void setRType(String type) {
		rType = type;
	}

	public void setRId(String id) {
		rId = id;
	}

	public void setRValue(String value) {
		rValue = value;
	}

	public void setRDate(Date date) {
		rDate = date;
	}

	/*
	 * overloads the setRDate method to accept a String of the millisecond time
	 * value.
	 */
	public void setRDate(String date) {
		Long L = new Long(date);
		rDate = new Date(L);
	}

	// =================================getters===================

	public String getClinic(){
		return clinic;
	}

	public String getPatientID() {
		return patientID;
	}

	public String getRType() {
		return rType;
	}

	public String getRId() {
		return rId;
	}

	public String getRValue() {
		return rValue;
	}

	public Date getRDate() {
		return rDate;
	}

	// =============================================================

	public String toString() {
		return "";
	}
}
