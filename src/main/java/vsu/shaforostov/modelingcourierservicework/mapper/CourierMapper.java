package vsu.shaforostov.modelingcourierservicework.mapper;


import org.springframework.stereotype.Component;
import vsu.shaforostov.modelingcourierservicework.dto.CourierDto.CourierDtoCreate;

import vsu.shaforostov.modelingcourierservicework.entity.Courier;

@Component
public class CourierMapper {

    public Courier mapToCourierEntity(CourierDtoCreate courierDtoCreate) {
        Courier courier = new Courier();
        courier.setCourierId(courierDtoCreate.getId());
        courier.setName(courierDtoCreate.getName());
        return courier;
    }

    public CourierDtoCreate mapToCourierDto(Courier courier) {
        CourierDtoCreate courierDtoCreate = new CourierDtoCreate();
        courierDtoCreate.setId(courier.getCourierId());
        courierDtoCreate.setName(courier.getName());
        return courierDtoCreate;
    }

}
