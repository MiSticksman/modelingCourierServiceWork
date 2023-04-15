package vsu.shaforostov.modelingcourierservicework.mapper;


import org.springframework.stereotype.Component;
import vsu.shaforostov.modelingcourierservicework.dto.CourierDto;
import vsu.shaforostov.modelingcourierservicework.entity.Courier;

@Component
public class CourierMapper {

    public Courier mapToCourierEntity(CourierDto courierDto) {
        Courier courier = new Courier();
        courier.setCourierId(courierDto.getCourierId());
        courier.setBids(courierDto.getBids());
        return courier;
    }

    public CourierDto mapToCourierDto(Courier courier) {
        CourierDto courierDto = new CourierDto();
        courierDto.setCourierId(courier.getCourierId());
        courierDto.setBids(courier.getBids());
        return courierDto;
    }


}
