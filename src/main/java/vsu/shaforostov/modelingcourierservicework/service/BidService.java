package vsu.shaforostov.modelingcourierservicework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.modelingcourierservicework.dto.BidDto;
import vsu.shaforostov.modelingcourierservicework.dto.BranchDto;
import vsu.shaforostov.modelingcourierservicework.entity.Bid;
import vsu.shaforostov.modelingcourierservicework.entity.Branch;
import vsu.shaforostov.modelingcourierservicework.mapper.BidMapper;
import vsu.shaforostov.modelingcourierservicework.repository.BidRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class BidService {

    private final BidRepository bidRepository;
    private final BidMapper bidMapper;


    public List<BidDto> findAll() {
        List<BidDto> list = new ArrayList<>();
        bidRepository.findAll().forEach(bid -> {
            list.add(bidMapper.mapToBidDto(bid));
        });
        return list;
    }

    public BidDto findById(Integer id) {
        Bid bid = bidRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
        return bidMapper.mapToBidDto(bid);
    }
    public void saveAll(List<BidDto> bidDtos) {
        List<Bid> bids = new ArrayList<>();
        bidDtos.forEach(bidDto -> {
            bids.add(bidMapper.mapToBidEntity(bidDto));
        });
        bidRepository.saveAll(bids);
    }

    public void save(BidDto bidDto) {
        Bid bid = bidMapper.mapToBidEntity(bidDto);
        bidRepository.save(bid);
    }

    public void delete(Integer id) {
        bidRepository.deleteById(id);
    }


}
