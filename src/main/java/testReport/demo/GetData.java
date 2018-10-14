package testReport.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testReport.mapper.Ab01;
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
    	jdbcTemplate.execute("select * from ab01");
        Map map = new HashMap();
        map.put("name","Yorke");
        map.put("telephone","15191457863");
        map.put("age","28");
        return map;
    }

    @RequestMapping("/getString")
    public String getData(){
    	customer.getCustomerById("1000000000");
        return "Yorke's first spring boot demo";
    }
    @RequestMapping("/getUser")
    public String getUser(){
    	Ab01 ab01 = customer.getUsersById(1000000000);
    	System.out.println(ab01.getAab011());
    	System.out.println(ab01.getAab012());
    	System.out.println(ab01.getAab013());
    	return ab01.getAab013();
    }

    @RequestMapping("/sendData")
    public String getDataFormPage(HttpServletRequest request){
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        return "successful";
    }
}
