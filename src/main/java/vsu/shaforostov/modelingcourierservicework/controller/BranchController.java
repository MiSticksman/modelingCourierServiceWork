package vsu.shaforostov.modelingcourierservicework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.modelingcourierservicework.dto.BranchDto;
import vsu.shaforostov.modelingcourierservicework.service.BranchService;

import java.util.List;

@RestController
@RequestMapping("/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @GetMapping
    public List<BranchDto> getAllBranches() {
        return branchService.findAll();
    }

    @GetMapping("/{id}")
    public BranchDto getBranchById(@PathVariable(name="id") Integer id) {
        return branchService.findById(id);
    }

    @PostMapping
    public void saveBranch(BranchDto branchDto) {
        branchService.save(branchDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable(name="id") Integer id) {
        branchService.delete(id);
    }
}
