package com.it.entity;

/**
 * Map entity. @author MyEclipse Persistence Tools
 */

public class Map implements java.io.Serializable {

	// Fields

	private Integer id;
	private Massage massage;
	private Double longitude;
	private Double latitude;
	private String photo;
	private String title;
	private String describe;

	// Constructors

	/** default constructor */
	public Map() {
	}

	/** minimal constructor */
	public Map(Massage massage) {
		this.massage = massage;
	}

	/** full constructor */
	public Map(Massage massage, Double longitude, Double latitude, String photo, String title, String describe) {
		this.massage = massage;
		this.longitude = longitude;
		this.latitude = latitude;
		this.photo = photo;
		this.title = title;
		this.describe = describe;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Massage getMassage() {
		return this.massage;
	}

	public void setMassage(Massage massage) {
		this.massage = massage;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}