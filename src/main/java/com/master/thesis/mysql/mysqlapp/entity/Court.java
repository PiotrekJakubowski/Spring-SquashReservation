package com.master.thesis.mysql.mysqlapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="court")
public class Court {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courtid")
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "sector")
	private String sector;
	
	public Court () {}

	public Court(String type, String sector) {
		super();
		this.type = type;
		this.sector = sector;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "Court [id=" + id + ", type=" + type + ", sector=" + sector + "]";
	}
	
}
