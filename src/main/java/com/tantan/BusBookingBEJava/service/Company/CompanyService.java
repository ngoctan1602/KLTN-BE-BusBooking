package com.tantan.BusBookingBEJava.service.Company;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Company.Company;
import com.tantan.BusBookingBEJava.exception.CustomException;
import com.tantan.BusBookingBEJava.mapper.Company.CompanyMapper;
import com.tantan.BusBookingBEJava.repository.CompanyRepository;
import com.tantan.BusBookingBEJava.request.Address.AddressRequest;
import com.tantan.BusBookingBEJava.request.Company.CompanyRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.service.Address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private IAddressService iAddressService;

    @Override
    @Transactional
    public boolean createNewCompany(CompanyRequest companyRequest) {
        Address address = iAddressService.createNewAddress(new AddressRequest(companyRequest.getRoad(), companyRequest.getIdWard()));
        Company company = CompanyMapper.INSTANCE.toEntity(companyRequest);
        company.setAddress(address);
        company.setStatus(Status.WAITING);
        try {
            companyRepository.save(company);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return false;
    }

    @Override
    @Transactional
    public boolean enableCompany(long idCompany) {
        Company company = getCompanyWithId(idCompany);
        company.setStatus(Status.ENABLE);
        try {
            companyRepository.save(company);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Company getCompanyWithId(long idCompany) {
        return companyRepository.findById(idCompany).orElseThrow(
                () -> new CustomException(
                        new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found company with id", null)
                )
        );
    }

    @Override
    public Page<Company> getAllCompany(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("id"));
        Page<Company> page = companyRepository.findAll(pageable);
        if (page.hasContent()) {
            return page;
        }
        throw new CustomException(
                new BaseResponse(true, HttpStatus.NOT_FOUND.value(), "Not found company with pageNumber = " + pageNumber + " and pageSize = " + pageSize, null)
        );
    }
}
