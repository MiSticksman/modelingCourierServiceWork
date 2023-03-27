package vsu.shaforostov.modelingcourierservicework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.modelingcourierservicework.dto.BranchDto;
import vsu.shaforostov.modelingcourierservicework.entity.Branch;
import vsu.shaforostov.modelingcourierservicework.repository.BranchRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    public List<BranchDto> findAll() {
        List<BranchDto> list = new ArrayList<>();
        branchRepository.findAll().forEach(branch -> {
            list.add(new BranchDto(branch.getBranchId(), branch.getName()));
        });
        return list;
    }

    public void saveAll(List<BranchDto> branchDtos) {
        List<Branch> branches = new ArrayList<>();
        branchDtos.forEach(branchDto -> {
            branches.add(new Branch(branchDto.getBranchId(), branchDto.getName()));
        });
        branchRepository.saveAll(branches);
    }

    public void save(BranchDto branchDto) {
        Branch branch = new Branch(branchDto.getBranchId(), branchDto.getName());
        branchRepository.save(branch);
    }
}
