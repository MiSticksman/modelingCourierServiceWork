package vsu.shaforostov.modelingcourierservicework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.modelingcourierservicework.dto.NavigatorDto;
import vsu.shaforostov.modelingcourierservicework.entity.Navigator;
import vsu.shaforostov.modelingcourierservicework.mapper.NavigatorMapper;
import vsu.shaforostov.modelingcourierservicework.repository.NavigatorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class NavigatorService {

    private final NavigatorRepository navigatorRepository;
    private final NavigatorMapper navigatorMapper;


    public List<NavigatorDto> findAll() {
        List<NavigatorDto> list = new ArrayList<>();
        navigatorRepository.findAll().forEach(navigator -> {
            list.add(navigatorMapper.mapToNavigatorDto(navigator));
        });
        return list;
    }

    public NavigatorDto findById(Integer id) {
        Navigator navigator = navigatorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
        return navigatorMapper.mapToNavigatorDto(navigator);
    }

    public void save(NavigatorDto navigatorDto) {
        Navigator navigator = navigatorMapper.mapToNavigatorEntity(navigatorDto);
        navigatorRepository.save(navigator);
    }

    public void delete(Integer id) {
        navigatorRepository.deleteById(id);
    }

}
