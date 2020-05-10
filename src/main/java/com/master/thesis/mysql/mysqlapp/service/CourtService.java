package com.master.thesis.mysql.mysqlapp.service;

import java.util.List;

import com.master.thesis.mysql.mysqlapp.entity.Court;

public interface CourtService {

	public List<Court> getCourts();
	
	public Court getCourt(int courtId);
		
	public void saveCourt(Court theCourt);
	
	public void updateCourt(Court theCourt);
	
	public void deleteCourt(int courtId);
	
}
