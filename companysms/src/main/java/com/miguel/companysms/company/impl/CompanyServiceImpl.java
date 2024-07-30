package com.miguel.companysms.company.impl;

import java.util.List;
import java.util.Optional;

import com.miguel.companysms.company.Company;
import com.miguel.companysms.company.CompanyRepository;
import com.miguel.companysms.company.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAll() {
		return this.companyRepository.findAll();
	}

	@Override
	public boolean update(Long id, Company company) {
		Optional<Company> companyOptional = this.companyRepository.findById(id);
		if (companyOptional.isPresent()) {
			Company companyToUpdate = companyOptional.get();
			companyToUpdate.setDescription(company.getDescription());
			companyToUpdate.setName(company.getName());
			this.companyRepository.save(companyToUpdate);
			return true;
		}
		return false;
	}

	@Override
	public void create(Company company) {
		this.companyRepository.save(company);
	}

	@Override
	public boolean delete(Long id) {
		if (this.companyRepository.existsById(id)) {
			this.companyRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
