package by.agency.travel.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import by.agency.travel.entity.Tour;
import by.agency.travel.service.TourService;
import by.agency.travel.web.validator.impl.AbstractValidator;

@Controller
public class TourController {
	
	@Inject
	private AbstractValidator tourValidator;
	
	@Inject
	private TourService tourService;
	
	@RequestMapping(value = "/tourfeed", method = {RequestMethod.GET, RequestMethod.POST})
	public String viewTourFeed(Model model) {
		model.addAttribute("tourList", tourService.findTours());
		return "tourList";
	}
	
	@RequestMapping(value = "{tourId}", method = RequestMethod.GET)
	public String viewTour(@PathVariable("tourId") int tourId, Model model) {
		Tour tour = tourService.findTourById(tourId);
		model.addAttribute("tour", tour);
		return "tour";
	}
	
	@RequestMapping(value = "/addition", method = RequestMethod.GET)
	public ModelAndView viewAddition(Model model) {
		Tour tour = new Tour();
		model.addAttribute("tourParam", tour);
		return new ModelAndView("addition", "tour", tour);
	}
	
	@RequestMapping(value = "/addition", method = RequestMethod.POST) 
	public ModelAndView addTour(@ModelAttribute("tourParam") Tour tour,
								BindingResult result, SessionStatus status) {
		tourValidator.validate(tour, result);
		if(result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("addition");
			modelAndView.addObject("tourParam", tour);
			return modelAndView;
		} else {
			status.setComplete();
			tourService.addTour(tour);
		}
		return new ModelAndView("redirect:/tourfeed", "tourParam", tour);
	}
}
