package vsu.shaforostov.modelingcourierservicework.mapper;


import org.springframework.stereotype.Controller;
import vsu.shaforostov.modelingcourierservicework.dto.BranchDto;
import vsu.shaforostov.modelingcourierservicework.entity.Branch;

@Controller
public class BranchMapper {
    public BranchDto mapToBranchDto(Branch branch) {
        BranchDto branchDto = new BranchDto();
        branchDto.setBranchId(branch.getBranchId());
        branchDto.setName(branch.getName());
        return branchDto;
    }
    public Branch mapToBranchEntity(BranchDto branchDto) {
        Branch branch = new Branch();
        branch.setBranchId(branchDto.getBranchId());
        branch.setName(branchDto.getName());
        return branch;
    }
}
