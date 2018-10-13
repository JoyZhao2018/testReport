package testReport.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("loadPage")
public class DemoLoadPage {

    @RequestMapping("/loadWelcome")
    public String loadWelcome(ModelMap map){
        map.addAttribute("helloWorld","~~~hello, World~~~");
//        map.put("helloWorld","~hello, World~");

        return "welcome/welcome";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request,ModelMap map){
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        map.addAttribute("username",request.getParameter("username"));
        return "index/index";
    }
    @RequestMapping("/exit")
    @ResponseBody
    public String exit(HttpServletRequest request,ModelMap map){

        return "Exit successful! Good Bye!";
    }
}
