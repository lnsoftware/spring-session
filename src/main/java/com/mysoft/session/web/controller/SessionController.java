package com.mysoft.session.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {

	@ResponseBody
	@RequestMapping("/spring-session/set")
	public String set(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String message = "ok";
		for(int i=0; i<10000; i++){
			session.setAttribute("key", "张阳11111"+i);
			Thread.sleep(100);
		}
		return message;
	}
	
	@ResponseBody
	@RequestMapping("/spring-session/get")
	public String get(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String message = "";
		message = (String) session.getAttribute("key");
		return message;
	}
	
}
