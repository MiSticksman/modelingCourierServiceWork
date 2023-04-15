package vsu.shaforostov.modelingcourierservicework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.modelingcourierservicework.dto.BidDto;
import vsu.shaforostov.modelingcourierservicework.service.BidService;

import java.util.List;

@RestController
@RequestMapping("/bids")
@RequiredArgsConstructor
public class BidController {
    private final BidService bidService;

    @GetMapping
    public List<BidDto> getBids() {
        return bidService.findAll();
    }

    @GetMapping("/{id}")
    public BidDto getBidById(@PathVariable(name="id") Integer id) {
        return bidService.findById(id);
    }

    @PostMapping
    public void saveBid(BidDto bidDto) {
        bidService.save(bidDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBid(@PathVariable(name="id") Integer id) {
        bidService.delete(id);
    }
}
