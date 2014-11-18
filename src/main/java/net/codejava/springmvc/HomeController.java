package net.codejava.springmvc;

import static net.codejava.springmvc.service.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static net.codejava.springmvc.service.UserServiceImpl.MIN_RECCOMEND_FOR_GOLD;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.codejava.springmvc.domain.Level;
import net.codejava.springmvc.domain.User;
import net.codejava.springmvc.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(Locale locale, Model model, @RequestParam(value="id") String id){		
		this.add();
		User user = this.userservice.get(id);
		//List<User> users = this.userService.getAll();
		model.addAttribute("user", user);
		return "userInfo";
	}
	
	public void add() {
		this.userservice.deleteAll();
		
		List<User> users = Arrays.asList(
				new User("bumjin", "박범진", "p1", "user1@ksug.org", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0), //49, 0
				new User("joytouch", "강명승", "p2", "user2@ksug.org", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0), //50, 0
				new User("erwins", 	"홍길동", "p3", "user3@ksug.org", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD - 1), //60, 29
				new User("madnite1", "이영자", "p4", "user4@ksug.org", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD), //60, 30
				new User("green", "이휘재", "p5", "user5@ksug.org", Level.GOLD, 100, Integer.MAX_VALUE)
			);

		this.userservice.add(users.get(0));
		this.userservice.add(users.get(1));
		this.userservice.add(users.get(2));
		this.userservice.add(users.get(3));
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
