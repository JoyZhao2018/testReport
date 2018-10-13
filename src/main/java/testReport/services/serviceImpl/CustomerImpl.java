package testReport.services.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testReport.daos.Aa01Mapper;
import testReport.mapper.Aa01;
import testReport.services.CustomerBS;
@Service
public class CustomerImpl implements CustomerBS {
	@Autowired
	private Aa01Mapper aa01Mapper;
	@Override
	public Aa01 getCustomerById(String id) {
//		Aa01 aa01 = aa01Mapper.selectByPrimaryKey(new BigDecimal(id));
//		System.out.println("name:" + aa01.getAaa002());
//		System.out.println("telephone:" + aa01.getAaa003());
//		return aa01;
		return null;
	}

	@Override
	public void updateCustomerById(Aa01 aa01) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomerById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Aa01> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
