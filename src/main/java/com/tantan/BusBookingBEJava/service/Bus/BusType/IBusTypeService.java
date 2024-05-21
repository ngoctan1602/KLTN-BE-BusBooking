package com.tantan.BusBookingBEJava.service.Bus.BusType;

import com.tantan.BusBookingBEJava.entity.Bus.TypeBus;
import com.tantan.BusBookingBEJava.request.Bus.TypeBus.TypeBusRequest;
import org.springframework.data.domain.Page;

public interface IBusTypeService {
    public boolean createNewTypeBus(TypeBusRequest typeBusRequest);
    public Page<TypeBus> getAllTypeBus(int pageNumber, int pageSize);
    public TypeBus getTypeBusById(long id);
    public boolean disableTypeBus(long id );
    public boolean enableTypeBus(long id );
}
