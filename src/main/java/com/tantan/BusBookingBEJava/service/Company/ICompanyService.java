package com.tantan.BusBookingBEJava.service.Company;

import com.tantan.BusBookingBEJava.entity.Company.Company;
import com.tantan.BusBookingBEJava.request.Company.CompanyRequest;
import org.springframework.data.domain.Page;

public interface ICompanyService {
    public boolean createNewCompany(CompanyRequest companyRequest);
    public boolean enableCompany(long idCompany);
    public Company getCompanyWithId(long idCompany);
    public Page<Company> getAllCompany(int pageNumber, int pageSize);
}
