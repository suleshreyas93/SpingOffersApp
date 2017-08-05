package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.Offers;
import dao.OffersDao;

@Component("offersServices")
public class OffersServices {
	
	private OffersDao offersDao;

	@Autowired
	public void setOffersDao(OffersDao offersDao) {
		this.offersDao = offersDao;
	}
	
	public List<Offers> getOffers()
	{
		List<Offers> allOffers = offersDao.getAllOffers();
		return allOffers;
	}

}
