package com.tantan.BusBookingBEJava.service.Address;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.entity.Address.Ward;
import com.tantan.BusBookingBEJava.repository.AddressRepository;
import com.tantan.BusBookingBEJava.request.Address.AddressRequest;
import com.tantan.BusBookingBEJava.service.Ward.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private IWardService iWardService;

    @Override
    @Transactional
    public boolean createNewAddress(AddressRequest addressRequest) {
        Ward ward = iWardService.getWardEntityById(addressRequest.getIdWard());
        try {
            Address address = new Address();
            address.setWard(ward);
            address.setRoad(addressRequest.getRoad());
            address.setFullName(addressRequest.getRoad() + ", " + ward.getFullAddress());
            addressRepository.save(address);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
