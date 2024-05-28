package com.tantan.BusBookingBEJava.service.Price;

import com.tantan.BusBookingBEJava.entity.Common.Status;
import com.tantan.BusBookingBEJava.entity.Price.Price;
import com.tantan.BusBookingBEJava.request.Price.PriceRequest;
import org.springframework.data.domain.Page;

public interface IPriceService {
    public boolean createNewPriceWithCompany( PriceRequest priceRequest);
    public Price getPriceWithId(long idPrice);
    public Page<Price> getPriceWithStatus(int pageNumber, int pageSize, Status status);
    public Page<Price> getAllPrice(int pageNumber, int pageSize );
    public boolean enablePrice(long idPrice);

}
