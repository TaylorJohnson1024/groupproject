package groupproject;

import java.sql.Date;

import java.util.Random;

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

	/* A constructor that generates a random id instead of using
	 * an already created ID.
	 */
	public Reading(String patientID, String clinic, String type, String value, Date date) {


		setClinic(clinic);
		setPatientID(patientID);
		setRType(type);
		this.rId = generateID();
		setRValue(value);
		setRDate(date);
	}

	/*
	 * accepts date as a String of the millisecond time value instead of an already
	 * instantiated Date Object.
	 */
	public Reading(String patientID, String clinic,String type, String id, String value, String date) {

		setClinic(clinic);
		setPatientID(patientID);
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

	//Used to generate a random reading id.
	public String generateID(){
		Random q = new Random();
		String id = "";
		String charBank = "abcdefghijklmnopqrstuvwxyz1234567890";
		for (int i = 5; i > 0; i--){
			id = id +(charBank.charAt(q.nextInt(charBank.length())));
		}
		return id;
	}

	public String toString() {
		return "";
	}
}
