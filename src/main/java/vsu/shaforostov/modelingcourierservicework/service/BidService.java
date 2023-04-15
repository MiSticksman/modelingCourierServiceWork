package vsu.shaforostov.modelingcourierservicework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.modelingcourierservicework.dto.BidDto.BidDtoCreate;
import vsu.shaforostov.modelingcourierservicework.dto.BidDto.BidDtoResponse;
import vsu.shaforostov.modelingcourierservicework.entity.Bid;
import vsu.shaforostov.modelingcourierservicework.entity.Courier;
import vsu.shaforostov.modelingcourierservicework.entity.Navigator;
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

    private final NavigatorService navigatorService;

    private final CourierService courierService;

    public List<BidDtoResponse> findAll() {
        List<BidDtoResponse> list = new ArrayList<>();
        bidRepository.findAll().forEach(bid -> {
            list.add(bidMapper.mapToBidDtoResponse(bid));
        });
        return list;
    }


    public Bid findEntityById(Integer id) {
        return bidRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
    }
    public BidDtoCreate findById(Integer id) {
        return bidMapper.mapToBidDto(findEntityById(id));
    }

//    public void saveAll(List<BidDtoCreate> bidDtoCreates) {
//        List<Bid> bids = new ArrayList<>();
//        bidDtoCreates.forEach(bidDtoCreate -> {
//            bids.add(bidMapper.mapToBidEntity(bidDtoCreate));
//        });
//        bidRepository.saveAll(bids);
//    }

    public void save(BidDtoCreate bidDtoCreate) {
        Navigator navigator = navigatorService.findEntityById(bidDtoCreate.getNavigatorId());
        Courier courier = courierService.findEntityById(bidDtoCreate.getCourierId());
        Bid bid = bidMapper.mapToBidEntity(bidDtoCreate, navigator, courier);
        bidRepository.save(bid);
    }

    public void delete(Integer id) {
        bidRepository.deleteById(id);
    }
}
