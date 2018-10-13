package testReport.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testReport.services.CustomerBS;

@RestController
@RequestMapping("getData")
public class GetData {
	@Autowired
	private CustomerBS customer;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/getJson")
    public Object returnJson(){
    	jdbcTemplate.execute("select * from aa01");
        Map map = new HashMap();
        map.put("name","Yorke");
        map.put("telephone","15191457863");
        map.put("age","28");
        return map;
    }

    @RequestMapping("/getString")
    public String getData(){
    	customer.getCustomerById("1000000052");
        return "Yorke's first spring boot demo";
    }

    @RequestMapping("/sendData")
    public String getDataFormPage(HttpServletRequest request){
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        return "successful";
    }
}
