package com.portablemind.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DefaultController {

	private String viewPath = "controller/default/";

	@RequestMapping(method = RequestMethod.GET)
	public String welcome() {

		return this.viewPath + "main";

	}

}