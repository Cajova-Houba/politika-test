package org.politika.Politika.service.impl;

import java.util.List;

import org.politika.Politika.dao.PrispevekDao;
import org.politika.Politika.generic.service.impl.GenericManagerImpl;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Prispevek;
import org.politika.Politika.service.PrispevekManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PrispevekManagerImpl extends GenericManagerImpl<Prispevek, Long> implements PrispevekManager{

	private PrispevekDao prispevekDao;
	
	@Autowired
	public PrispevekManagerImpl(@Qualifier("prispevekDao") PrispevekDao prispevekDao) {
		super(prispevekDao);
		this.prispevekDao = prispevekDao;
	}
	
	public List<Prispevek> getAll(Kategorie kategorie) {
		// TODO Auto-generated method stub
		return prispevekDao.getAll(kategorie);
	}

	public List<Prispevek> getAll(long kategorieId) {
		// TODO Auto-generated method stub
		return prispevekDao.getAll(kategorieId);
	}

}
