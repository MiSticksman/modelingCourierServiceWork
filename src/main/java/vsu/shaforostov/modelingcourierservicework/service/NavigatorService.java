package vsu.shaforostov.modelingcourierservicework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.modelingcourierservicework.dto.NavigatorDto.NavigatorDtoCreate;
import vsu.shaforostov.modelingcourierservicework.entity.Branch;
import vsu.shaforostov.modelingcourierservicework.entity.Navigator;
import vsu.shaforostov.modelingcourierservicework.mapper.BranchMapper;
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
    private final BranchService branchService;


    public List<NavigatorDtoCreate> findAll() {
        List<NavigatorDtoCreate> list = new ArrayList<>();
        navigatorRepository.findAll().forEach(navigator -> {
            list.add(navigatorMapper.mapToNavigatorDto(navigator));
        });
        return list;
    }


    public Navigator findEntityById(Integer id) {
        return navigatorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
    }

    public NavigatorDtoCreate findById(Integer id) {
        return navigatorMapper.mapToNavigatorDto(findEntityById(id));
    }



    public void save(NavigatorDtoCreate navigatorDtoCreate) {
        Branch from = branchService.findEntityById(navigatorDtoCreate.getFromId());
        Branch to = branchService.findEntityById(navigatorDtoCreate.getToId());
        Navigator navigator = navigatorMapper.mapToNavigatorEntity(navigatorDtoCreate, from, to);
        navigatorRepository.save(navigator);
    }

    public void delete(Integer id) {
        navigatorRepository.deleteById(id);
    }

}
