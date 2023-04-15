package vsu.shaforostov.modelingcourierservicework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.modelingcourierservicework.dto.BranchDto;
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

    public List<BranchDto> findAll() {
        List<BranchDto> list = new ArrayList<>();
        branchRepository.findAll().forEach(branch -> {
            list.add(branchMapper.mapToBranchDto(branch));
        });
        return list;
    }

    public BranchDto findById(Integer id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
        return branchMapper.mapToBranchDto(branch);
    }
    public void saveAll(List<BranchDto> branchDtos) {
        List<Branch> branches = new ArrayList<>();
        branchDtos.forEach(branchDto -> {
            branches.add(branchMapper.mapToBranchEntity(branchDto));
        });
        branchRepository.saveAll(branches);
    }

    public void save(BranchDto branchDto) {
        Branch branch = branchMapper.mapToBranchEntity(branchDto);
        branchRepository.save(branch);
    }


    public void delete(Integer id) {
        branchRepository.deleteById(id);
    }
}
