package com.skcc.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.demo.vo.UserVo;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	public Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unused")
	@Autowired
	private MessageSource messageSource;

	@PostMapping
	public ResponseEntity<?> updateUser(HttpSession session, Model model, @RequestParam UserVo userVo) {
//		model.addAttribute("welcome", messageSource.getMessage("welcome", null, LocaleContextHolder.getLocale()));
		model.addAttribute("welcome", "Thie is a Demo Application !!");

		logger.debug("Title in the session is {}", session.getAttribute("title"));
		logger.debug("Title in the session is {}", model.getAttribute("welcome"));

		return ResponseEntity.ok(userVo);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getUser(HttpSession session, @PathVariable int id) {

		logger.debug("ID is {}", id);

		UserVo userVo = new UserVo();
		userVo.setId(id);
		userVo.setName("Cloud Application Demo");
		
		logger.debug("User is {}", userVo);

		return ResponseEntity.ok(userVo);
	}
	
	@GetMapping
	public ResponseEntity<?> getUsers(HttpSession session) {

		List<UserVo> list = new ArrayList<UserVo>();
		
		for (int i = 1; i < 5; i++) {
			UserVo userVo = new UserVo();
			userVo.setId(i);
			userVo.setName("Cloud Application Demo");
			list.add(userVo);
			logger.debug("User is {}", userVo);
		}
		
		return ResponseEntity.ok(list);
	}
}
