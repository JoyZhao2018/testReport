package testReport.services;

import java.util.List;

import testReport.mapper.Aa01;
import testReport.mapper.Ab01;

public interface CustomerBS {
	public Aa01 getCustomerById(String id);
	public void updateCustomerById(Aa01 aa01);
	public void deleteCustomerById(String id);
	public List<Aa01> getAllCustomers();
	public Ab01 getUsersById(int id);
}
