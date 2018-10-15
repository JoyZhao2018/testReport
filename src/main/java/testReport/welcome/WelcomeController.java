package testReport.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("welcome")
public class WelcomeController {
	@RequestMapping("/loginPage")
	public String loginPage(){
        return "welcome/welcome";
    }
}
