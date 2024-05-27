package com.tantan.BusBookingBEJava.controller.company;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.entity.Company.Company;
import com.tantan.BusBookingBEJava.mapper.Address.AddressMapper;
import com.tantan.BusBookingBEJava.mapper.Company.CompanyMapper;
import com.tantan.BusBookingBEJava.request.Company.CompanyRequest;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponse;
import com.tantan.BusBookingBEJava.response.BaseRespone.BaseResponseWithPaginate;
import com.tantan.BusBookingBEJava.response.BaseRespone.Paginate;
import com.tantan.BusBookingBEJava.response.Company.CompanyResponse;
import com.tantan.BusBookingBEJava.service.Address.IAddressService;
import com.tantan.BusBookingBEJava.service.Company.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    @Autowired
    private ICompanyService iCompanyService;
    @Autowired
    private IAddressService iAddressService;

    @GetMapping("")
    public ResponseEntity<BaseResponseWithPaginate> getAllCompany(@RequestParam int pageNumber,
                                                                  @RequestParam int pageSize) {
        Page<Company> page = iCompanyService.getAllCompany(pageNumber, pageSize);
        List<CompanyResponse> companyResponses = page.getContent().stream().map(
                company ->{
                    CompanyResponse companyResponse = CompanyMapper.INSTANCE.toResponse(company);
                    companyResponse.setAddressResponse(iAddressService.mapRequestToResponse(company.getAddress()));
                    return companyResponse;
                }
        ).toList();
        return ResponseEntity.ok(
                new BaseResponseWithPaginate(false, HttpStatus.OK.value(), "Get all company successfully",
                        new Paginate(pageSize, pageNumber, page.getTotalPages()),
                        companyResponses
                )
        );
    }

    @PutMapping("/enable/{idCompany}")
    public ResponseEntity<BaseResponse> enableCompany(@PathVariable long idCompany) {
        iCompanyService.enableCompany(idCompany);
        return ResponseEntity.ok(
                new BaseResponse(false, HttpStatus.OK.value(), "Enable company successfully", null)
        );
    }
    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createNewCompany(@RequestBody CompanyRequest companyRequest) {
       iCompanyService.createNewCompany(companyRequest);
        return ResponseEntity.ok(
                new BaseResponse(false, HttpStatus.OK.value(), "Create new company successfully", null)
        );
    }
}
