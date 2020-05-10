package com.master.thesis.mysql.mysqlapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="court_id")
	private Court court;
	
	@Column(name = "reservation_date")
	private String date;
	
	@ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
	
	public Reservation() {}

	public Reservation(Court court, String date, Client client) {
		super();
		this.court = court;
		this.date = date;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "ReservationDetails [id=" + id + ", court=" + court + ", date=" + date + ", client=" + client + "]";
	}
	
}
