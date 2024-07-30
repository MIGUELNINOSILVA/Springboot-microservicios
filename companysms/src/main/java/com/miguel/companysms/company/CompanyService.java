package com.miguel.companysms.company;

import java.util.List;

public interface CompanyService {

	List<Company> getAll();
	boolean update(Long id, Company company);
	void create(Company company);
	boolean delete(Long id);
}
