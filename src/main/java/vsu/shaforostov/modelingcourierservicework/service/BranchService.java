package vsu.shaforostov.modelingcourierservicework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.modelingcourierservicework.dto.BranchDto.BranchDtoCreate;
import vsu.shaforostov.modelingcourierservicework.entity.Branch;
import vsu.shaforostov.modelingcourierservicework.mapper.BranchMapper;
import vsu.shaforostov.modelingcourierservicework.repository.BranchRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    public List<BranchDtoCreate> findAll() {
        List<BranchDtoCreate> list = new ArrayList<>();
        branchRepository.findAll().forEach(branch -> {
            list.add(branchMapper.mapToBranchDto(branch));
        });
        return list;
    }

    public Branch findEntityById(Integer id) {
        return branchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
    }

    public BranchDtoCreate findById(Integer id) {
        return branchMapper.mapToBranchDto(findEntityById(id));
    }
    public void saveAll(List<BranchDtoCreate> branchDtoCreates) {
        List<Branch> branches = new ArrayList<>();
        branchDtoCreates.forEach(branchDtoCreate -> {
            branches.add(branchMapper.mapToBranchEntity(branchDtoCreate));
        });
        branchRepository.saveAll(branches);
    }

    public void save(BranchDtoCreate branchDtoCreate) {
        Branch branch = branchMapper.mapToBranchEntity(branchDtoCreate);
        branchRepository.save(branch);
    }


    public void delete(Integer id) {
        branchRepository.deleteById(id);
    }
}
