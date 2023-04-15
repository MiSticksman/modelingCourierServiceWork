package vsu.shaforostov.modelingcourierservicework.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.modelingcourierservicework.dto.CourierDto;
import vsu.shaforostov.modelingcourierservicework.entity.Courier;
import vsu.shaforostov.modelingcourierservicework.mapper.CourierMapper;
import vsu.shaforostov.modelingcourierservicework.repository.CourierRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;


    public List<CourierDto> findAll() {

        List<CourierDto> list = new ArrayList<>();
        courierRepository.findAll().forEach(courier -> {
            list.add(courierMapper.mapToCourierDto(courier));
        });
        return list;
    }

    public CourierDto findById(Integer id) {
        Courier courier = courierRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
        return courierMapper.mapToCourierDto(courier);
    }

    public void save(CourierDto courierDto) {
        Courier courier = courierMapper.mapToCourierEntity(courierDto);
        courierRepository.save(courier);
    }

}
