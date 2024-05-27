package com.tantan.BusBookingBEJava.service.User;

import com.tantan.BusBookingBEJava.entity.Address.Address;
import com.tantan.BusBookingBEJava.entity.User.User;
import com.tantan.BusBookingBEJava.mapper.User.UserMapper;
import com.tantan.BusBookingBEJava.repository.UserRepository;
import com.tantan.BusBookingBEJava.request.Address.AddressRequest;
import com.tantan.BusBookingBEJava.request.User.UserRequest;
import com.tantan.BusBookingBEJava.service.Address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IAddressService iAddressService;

    @Override
    public boolean createNewUser(UserRequest userRequest) {
        Address address = iAddressService.createNewAddress(new AddressRequest(userRequest.getRoad(), userRequest.getIdWard()));
        User user = UserMapper.INSTANCE.toEntity(userRequest);
        user.setAddress(address);
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
