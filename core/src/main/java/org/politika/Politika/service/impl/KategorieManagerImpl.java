package org.politika.Politika.service.impl;

import java.util.List;

import org.politika.Politika.dao.KategorieDao;
import org.politika.Politika.generic.service.impl.GenericManagerImpl;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Osoba;
import org.politika.Politika.service.KategorieManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class KategorieManagerImpl extends GenericManagerImpl<Kategorie, Long> implements
		KategorieManager {

	private KategorieDao kategorieDao;

	@Autowired
	public KategorieManagerImpl(@Qualifier("kategorieDao") KategorieDao kategorieDao) {
		super(kategorieDao);
		this.kategorieDao = kategorieDao;
	}
	
	public List<Kategorie> getAllMain() {
		// TODO Auto-generated method stub
		return kategorieDao.getAllMain();
	}

	public List<Osoba> getAllPersons(long kategorieId) {
		// TODO Auto-generated method stub
		return kategorieDao.getAllPersons(kategorieId);
	}

}
