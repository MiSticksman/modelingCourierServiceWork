package vsu.shaforostov.modelingcourierservicework.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.modelingcourierservicework.dto.NavigatorDto;
import vsu.shaforostov.modelingcourierservicework.entity.Navigator;
import vsu.shaforostov.modelingcourierservicework.service.NavigatorService;

import java.util.List;

@RestController
@RequestMapping("/navigators")
@RequiredArgsConstructor
public class NavigatorController {

    private final NavigatorService navigatorService;


    @GetMapping
    public List<NavigatorDto> getNavigators() {
        return navigatorService.findAll();
    }

    @GetMapping("/{id}")
    public NavigatorDto getNavigatorById(@PathVariable(name="id") Integer id) {
        return navigatorService.findById(id);
    }

    @PostMapping
    public void saveNavigator(NavigatorDto navigatorDto) {
        navigatorService.save(navigatorDto);
    }

    @DeleteMapping("/{id}")
    public void deleteNavigator(@PathVariable(name="id") Integer id) {
        navigatorService.delete(id);
    }
}
