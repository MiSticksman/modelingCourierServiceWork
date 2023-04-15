package vsu.shaforostov.modelingcourierservicework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.modelingcourierservicework.dto.NavigatorDto.NavigatorDtoCreate;
import vsu.shaforostov.modelingcourierservicework.service.NavigatorService;

import java.util.List;

@RestController
@RequestMapping("/navigators")
@RequiredArgsConstructor
public class NavigatorController {

    private final NavigatorService navigatorService;


    @GetMapping
    public List<NavigatorDtoCreate> getNavigators() {
        return navigatorService.findAll();
    }

    @GetMapping("/{id}")
    public NavigatorDtoCreate getNavigatorById(@PathVariable(name="id") Integer id) {
        return navigatorService.findById(id);
    }

    @PostMapping
    public void saveNavigator(@RequestBody NavigatorDtoCreate navigatorDtoCreate) {
        navigatorService.save(navigatorDtoCreate);
    }

    @DeleteMapping("/{id}")
    public void deleteNavigator(@PathVariable(name="id") Integer id) {
        navigatorService.delete(id);
    }
}
