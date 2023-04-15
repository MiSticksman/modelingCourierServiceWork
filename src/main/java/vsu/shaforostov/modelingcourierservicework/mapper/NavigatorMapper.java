package vsu.shaforostov.modelingcourierservicework.mapper;

import org.springframework.stereotype.Component;
import vsu.shaforostov.modelingcourierservicework.dto.NavigatorDto.NavigatorDtoCreate;
import vsu.shaforostov.modelingcourierservicework.entity.Branch;
import vsu.shaforostov.modelingcourierservicework.entity.Navigator;


@Component
public class NavigatorMapper {

    public Navigator mapToNavigatorEntity(NavigatorDtoCreate navigatorDtoCreate, Branch from, Branch to) {
        Navigator navigator = new Navigator();
        navigator.setNavigatorId(navigatorDtoCreate.getId());
        navigator.setTimeFromTo(navigatorDtoCreate.getTimeFromTo());
        navigator.setFrom(from);
        navigator.setTo(to);
        return navigator;
    }

    public NavigatorDtoCreate mapToNavigatorDto(Navigator navigator) {
        NavigatorDtoCreate navigatorDtoCreate = new NavigatorDtoCreate();
        navigatorDtoCreate.setId(navigator.getNavigatorId());
        navigatorDtoCreate.setTimeFromTo(navigator.getTimeFromTo());
        navigatorDtoCreate.setFromId(navigator.getFrom().getBranchId());
        navigatorDtoCreate.setToId(navigator.getTo().getBranchId());
        return navigatorDtoCreate;
    }

}
