package com.skcc.demo.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

	public Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unused")
	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public ResponseEntity<?> getContents(HttpSession session, Model model) {
//		model.addAttribute("welcome", messageSource.getMessage("welcome", null, LocaleContextHolder.getLocale()));
		model.addAttribute("welcome", "Thie is a Demo Application !!");

		logger.debug("Title in the session is {}", session.getAttribute("title"));
		logger.debug("Title in the session is {}", model.getAttribute("welcome"));

		return ResponseEntity.ok(model);
	}
}
