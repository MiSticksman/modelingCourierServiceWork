package vsu.shaforostov.modelingcourierservicework.mapper;

import org.springframework.stereotype.Component;
import vsu.shaforostov.modelingcourierservicework.dto.NavigatorDto;
import vsu.shaforostov.modelingcourierservicework.entity.Navigator;


@Component
public class NavigatorMapper {

    public Navigator mapToNavigatorEntity(NavigatorDto navigatorDto) {
        Navigator navigator = new Navigator();
        navigator.setNavigatorId(navigatorDto.getNavigatorId());
        navigator.setTimeFromTo(navigatorDto.getTimeFromTo());
        navigator.setFrom(navigatorDto.getFrom());
        navigator.setTo(navigatorDto.getTo());
        return navigator;
    }

    public NavigatorDto mapToNavigatorDto(Navigator navigator) {
        NavigatorDto navigatorDto = new NavigatorDto();
        navigatorDto.setNavigatorId(navigator.getNavigatorId());
        navigatorDto.setTimeFromTo(navigator.getTimeFromTo());
        navigatorDto.setFrom(navigator.getFrom());
        navigator.setTo(navigator.getTo());
        return navigatorDto;
    }

}
