package vsu.shaforostov.modelingcourierservicework.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.modelingcourierservicework.dto.CourierDto.CourierDtoCreate;
import vsu.shaforostov.modelingcourierservicework.entity.Bid;
import vsu.shaforostov.modelingcourierservicework.entity.Courier;
import vsu.shaforostov.modelingcourierservicework.mapper.CourierMapper;
import vsu.shaforostov.modelingcourierservicework.repository.BidRepository;
import vsu.shaforostov.modelingcourierservicework.repository.CourierRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;

    private final BidRepository bidRepository;


    public List<CourierDtoCreate> findAll() {
        List<CourierDtoCreate> list = new ArrayList<>();
        courierRepository.findAll().forEach(courier -> {
            list.add(courierMapper.mapToCourierDto(courier));
        });
        return list;
    }


    public Courier findEntityById(Integer id) {
        return courierRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
    }
    public CourierDtoCreate findById(Integer id) {
        return courierMapper.mapToCourierDto(findEntityById(id));
    }

    public void save(CourierDtoCreate courierDtoCreate) {
        Courier courier = courierMapper.mapToCourierEntity(courierDtoCreate);
        courierRepository.save(courier);
    }

    public void delete(Integer id) {
        courierRepository.deleteById(id);
    }

}
