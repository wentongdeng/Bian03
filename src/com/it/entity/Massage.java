package com.it.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Massage entity. @author MyEclipse Persistence Tools
 */

public class Massage implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String text;
	private String title;
	private Integer like;
	private String time;
	private Set maps = new HashSet(0);

	// Constructors

	/** default constructor */
	public Massage() {
	}

	/** minimal constructor */
	public Massage(User user) {
		this.user = user;
	}

	/** full constructor */
	public Massage(User user, String text, String title, Integer like, String time, Set maps) {
		this.user = user;
		this.text = text;
		this.title = title;
		this.like = like;
		this.time = time;
		this.maps = maps;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getLike() {
		return this.like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Set getMaps() {
		return this.maps;
	}

	public void setMaps(Set maps) {
		this.maps = maps;
	}

}