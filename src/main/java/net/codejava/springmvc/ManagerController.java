package net.codejava.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = " **")
public class ManagerController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(Locale locale, Model model, int id) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("message", "Complete to Delete User (id=" + id + ")");
		
		return "deleteUserComplete";
	}
	
}
