package vsu.shaforostov.modelingcourierservicework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.modelingcourierservicework.dto.BidDto.BidDtoCreate;
import vsu.shaforostov.modelingcourierservicework.dto.BidDto.BidDtoResponse;
import vsu.shaforostov.modelingcourierservicework.service.BidService;

import java.util.List;

@RestController
@RequestMapping("/bids")
@RequiredArgsConstructor
public class BidController {
    private final BidService bidService;

    @GetMapping
    public List<BidDtoResponse> getBids() {
        return bidService.findAll();
    }

    @GetMapping("/{id}")
    public BidDtoCreate getBidById(@PathVariable(name="id") Integer id) {
        return bidService.findById(id);
    }

    @PostMapping
    public void saveBid(@RequestBody BidDtoCreate bidDtoCreate) {
        bidService.save(bidDtoCreate);
    }

    @DeleteMapping("/{id}")
    public void deleteBid(@PathVariable(name="id") Integer id) {
        bidService.delete(id);
    }
}
