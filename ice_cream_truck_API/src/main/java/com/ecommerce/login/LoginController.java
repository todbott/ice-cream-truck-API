// -- NOTE ---
// This API originally used Spring Security and Java Web Tokens (JWT)
// to secure the endpoints, and login was required.  For the current ice cream truck API,
// securing the endpoints was not necessary, so this file is not
// necessary.

package com.ecommerce.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView showLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
}