package com.beans;

public class Courses {
	private int id;
	private String number;
	private String name;

	/**
	 * 
	 * @param id
	 * @param number
	 * @param name
	 */
	public Courses(int id, String number, String name) {
		this.id = id;
		this.number = number;
		this.name = name;
	}
	
	public Courses() {
		
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
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
