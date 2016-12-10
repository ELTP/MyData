package com.psl.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psl.bean.Admin;
import com.psl.bean.Donor;
import com.psl.service.BloodBankService;

@Controller
public class DonorController {
	@Autowired
	private BloodBankService service;

	@RequestMapping(value = { "/home" }, method = RequestMethod.POST)
	public String registerDonar(Model model,
			 @ModelAttribute @Valid Donor donor, BindingResult bind) {
		System.out.println("inside post");
		if (bind.hasErrors()) {
			
			System.out.println("errrorr");
			/*List<Donor> list = service.getAllDonar();
			model.addAttribute("donor", new Donor());
			model.addAttribute("donorList", list);*/
			return "DonorHome";
		} else {
			service.addDonar(donor);
			return "redirect:/home";
		}
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String showDonar(Model model) {
		System.out.println("inside get...");

		List<Donor> list = service.getAllDonar();
		model.addAttribute("donor", new Donor());
		model.addAttribute("donorList", list);
		// service.addDonar(donar);
		return "DonorHome";
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String usrLogin(Model model) {
		model.addAttribute("admin", new Admin());
		return "Login";
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.POST)
	public String usrLogin(Model model, @Valid Admin admin, BindingResult bind) {

		int flag = service.userLogin(admin);
		if (flag == 1)
			return "redirect:/home";
		else {
			// model.addAttribute("msg", new String( msg));
			return "Login";
		}
	}

	@RequestMapping(value = { "/update/{donorId}/{bloodgroup}" }, method = RequestMethod.GET)
	public String updateBloodGroup(Model model,
			@PathVariable String bloodgroup, @PathVariable String donorId) {

		System.out.println("inside update...");

		service.updateBloodGroup(bloodgroup, donorId);
		return "redirect:/home";
	}

	@RequestMapping(value = { "/userdetails/{user}" })
	public String userdetails(Model model, @PathVariable String user) {

		List<Donor> donorList = service.getDonor(user);
		model.addAttribute("donor", new Donor());
		model.addAttribute("donorList", donorList);

		return "userDetails";

	}

}
