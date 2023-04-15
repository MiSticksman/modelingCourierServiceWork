package vsu.shaforostov.modelingcourierservicework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.modelingcourierservicework.dto.CourierDto.CourierDtoCreate;
import vsu.shaforostov.modelingcourierservicework.service.CourierService;

import java.util.List;

@RestController
@RequestMapping("/couriers")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @GetMapping
    public List<CourierDtoCreate> getCouriers() {
        return courierService.findAll();
    }

    @GetMapping("/{id}")
    public CourierDtoCreate getCourierById(@PathVariable(name="id") Integer id) {
        return courierService.findById(id);
    }

    @PostMapping
    public void saveCourier(@RequestBody CourierDtoCreate courierDtoCreate) {
        courierService.save(courierDtoCreate);
    }

    @DeleteMapping("/{id}")
    public void deleteCourier(@PathVariable(name="id") Integer id) {
        courierService.delete(id);
    }
}
