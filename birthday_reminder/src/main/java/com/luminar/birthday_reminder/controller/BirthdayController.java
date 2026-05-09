package com.luminar.birthday_reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.luminar.birthday_reminder.entity.BirthdayReminder;
import com.luminar.birthday_reminder.repository.BirthdayRepository;
import com.luminar.birthday_reminder.service.EmailService;

@Controller
public class BirthdayController {
	
	@Autowired
	private BirthdayRepository repository;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("birthday", new BirthdayReminder());
		
		model.addAttribute("birthdays", repository.findAll());
		
		return "index";
	}
	
	
	@PostMapping("/save")
	public String saveBirthday(@ModelAttribute BirthdayReminder birthdayReminder) {
		repository.save(birthdayReminder);
		String message =
		        "Hey " + birthdayReminder.getName() + ",\n\n" +
		        "You’ve been added to my personal birthday reminder list 🎉\n\n" +
		        "I built this small app to make sure I never miss important birthdays.\n\n" +
		        "So if you get a birthday message someday… now you know why 😄\n\n" +
		        "– Parvin";

		emailService.sendMail(
		        birthdayReminder.getEmail(),
		        "Welcome to Parvin's Birthday Reminder 🎉",
		        message
		);
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id,Model model) {
		BirthdayReminder existing =repository.findById(id).orElseThrow(()->new RuntimeException("person not found"));
		
		model.addAttribute("birthday",existing);
		model.addAttribute("birthdays", repository.findAll());
		
		return "index";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BirthdayReminder birthdayReminder) {
		repository.save(birthdayReminder);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		repository.deleteById(id);
		 return "redirect:/";
	}

}
