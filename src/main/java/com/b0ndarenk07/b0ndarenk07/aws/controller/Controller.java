package com.b0ndarenk07.b0ndarenk07.aws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/getuser")
	public static String getName() {
		return "Hi my name is Vlad";
	}
}

