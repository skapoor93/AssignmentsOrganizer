package com.beans;

public class Assignments {
	private int id;
	private String description;
	private int status;
	private int courseId;

	/**
	 * 
	 * @param id
	 * @param description
	 * @param status
	 * @param courseId
	 */
	public Assignments(int id, String description, int status, int courseId) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.courseId = courseId;
	}
	
	public Assignments() {
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
}