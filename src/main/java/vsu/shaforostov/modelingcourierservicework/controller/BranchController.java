package vsu.shaforostov.modelingcourierservicework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.modelingcourierservicework.dto.BranchDto.BranchDtoCreate;
import vsu.shaforostov.modelingcourierservicework.service.BranchService;

import java.util.List;

@RestController
@RequestMapping("/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @GetMapping
    public List<BranchDtoCreate> getAllBranches() {
        return branchService.findAll();
    }

    @GetMapping("/{id}")
    public BranchDtoCreate getBranchById(@PathVariable(name="id") Integer id) {
        return branchService.findById(id);
    }

    @PostMapping
    public void saveBranch(@RequestBody BranchDtoCreate branchDtoCreate) {
        branchService.save(branchDtoCreate);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable(name="id") Integer id) {
        branchService.delete(id);
    }
}
