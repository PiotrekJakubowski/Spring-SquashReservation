package com.master.thesis.mysql.mysqlapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.master.thesis.mysql.mysqlapp.dao.CourtDAO;
import com.master.thesis.mysql.mysqlapp.entity.Court;

@Service
public class ImplCourtService implements CourtService {

	@Autowired
	CourtDAO courtDao;
	
	@Override
	@Transactional
	public List<Court> getCourts() {
		return courtDao.getCourts();
	}

	@Override
	@Transactional
	public Court getCourt(int courtId) {
		return courtDao.getCourt(courtId);
	}

	@Override
	@Transactional
	public void saveCourt(Court theCourt) {
		courtDao.saveCourt(theCourt);
	}

	@Override
	@Transactional
	public void updateCourt(Court theCourt) {
		courtDao.updateCourt(theCourt);
	}

	@Override
	@Transactional
	public void deleteCourt(int courtId) {
		courtDao.deleteCourt(courtId);
	}

}
