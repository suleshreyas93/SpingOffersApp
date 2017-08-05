package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.Offers;
import services.OffersServices;

@Controller
public class OffersController {
	
	private OffersServices offersServies;
	
	@Autowired
	public void setOffersServies(OffersServices offersServies) {
		this.offersServies = offersServies;
	}

	@RequestMapping("/offers")
	public String showOffers(Model model)
	{
		List<Offers> offer = offersServies.getOffers();
		model.addAttribute("offer", offer);
		
		return "offers";
	}
	
	@RequestMapping("/createOffer")
	public String createOffers()
	{
		return "createOffer";
	}

}
