package vsu.shaforostov.modelingcourierservicework.mapper;


import org.springframework.stereotype.Component;
import vsu.shaforostov.modelingcourierservicework.dto.BranchDto.BranchDtoCreate;
import vsu.shaforostov.modelingcourierservicework.entity.Branch;

@Component
public class BranchMapper {
    public BranchDtoCreate mapToBranchDto(Branch branch) {
        BranchDtoCreate branchDtoCreate = new BranchDtoCreate();
        branchDtoCreate.setId(branch.getBranchId());
        branchDtoCreate.setName(branch.getName());
        return branchDtoCreate;
    }
    public Branch mapToBranchEntity(BranchDtoCreate branchDtoCreate) {
        Branch branch = new Branch();
        branch.setBranchId(branchDtoCreate.getId());
        branch.setName(branchDtoCreate.getName());
        return branch;
    }
}
