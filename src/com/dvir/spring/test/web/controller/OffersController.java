package com.dvir.spring.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dvir.spring.test.web.dao.Offer;
import com.dvir.spring.test.web.service.OfferService;

@Controller
public class OffersController {
	private OfferService offerService;

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		// offerService.throwTestException();
		List<Offer> offersList = offerService.getCurrent();
		model.addAttribute("offers", offersList);
		return "Offers";

	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("Id is - " + id);
		return "Home";

	}

	@RequestMapping("/create-offers")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "CreateOffer";
	}

	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {

		if (result.hasErrors()) {
			return "CreateOffer";
		}

		offerService.create(offer);

		return "offerCreated";
	}

	@Autowired
	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}

}
