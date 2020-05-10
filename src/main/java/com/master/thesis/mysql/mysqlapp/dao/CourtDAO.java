package com.master.thesis.mysql.mysqlapp.dao;

import java.util.List;

import com.master.thesis.mysql.mysqlapp.entity.Court;

public interface CourtDAO {

	public List<Court> getCourts();
	
	public Court getCourt(int courtId);
		
	public void saveCourt(Court theCourt);
	
	public void updateCourt(Court theCourt);
	
	public void deleteCourt(int courtId);
	
}
