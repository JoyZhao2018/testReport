package testReport.initization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import testReport.daos.Aa02Mapper;
import testReport.mapper.Aa02;
@Component
public class InitDataFromDB implements CommandLineRunner {

	@Autowired
	private Aa02Mapper aa02Mapper;
	private String[] URLList;
	
	@Override
	public void run(String... args) throws Exception {
		List<Aa02> aa02List = aa02Mapper.selectAll();
		if(aa02List != null || aa02List.size() > 0) {
			URLList = new String[aa02List.size()];
			for (int i = 0; i < aa02List.size(); i++) {
				URLList[i] = aa02List.get(i).getAaa023();
			}
		}
	}

	public String[] getURLList() {
		return URLList;
	}


}
