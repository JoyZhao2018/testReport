package testReport.services;

import java.util.List;

import testReport.mapper.Aa01;

public interface CustomerBS {
	public Aa01 getCustomerById(String id);
	public void updateCustomerById(Aa01 aa01);
	public void deleteCustomerById(String id);
	public List<Aa01> getAllCustomers();
}
