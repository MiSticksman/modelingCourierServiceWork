package vsu.shaforostov.modelingcourierservicework.mapper;

import org.springframework.stereotype.Component;
import vsu.shaforostov.modelingcourierservicework.dto.BidDto.BidDtoCreate;
import vsu.shaforostov.modelingcourierservicework.dto.BidDto.BidDtoResponse;
import vsu.shaforostov.modelingcourierservicework.entity.Bid;
import vsu.shaforostov.modelingcourierservicework.entity.Courier;
import vsu.shaforostov.modelingcourierservicework.entity.Navigator;


@Component
public class BidMapper {

    public Bid mapToBidEntity(BidDtoCreate bidDtoCreate, Navigator navigator, Courier courier) {
        Bid bid = new Bid();
        bid.setBidId(bidDtoCreate.getId());
        bid.setNavigator(navigator);
        bid.setCourier(courier);
        bid.setUrgency(bidDtoCreate.getUrgency());
        return bid;
    }

    public BidDtoCreate mapToBidDto(Bid bid) {
        BidDtoCreate bidDtoCreate = new BidDtoCreate();
        bidDtoCreate.setId(bid.getBidId());
        bidDtoCreate.setNavigatorId(bid.getNavigator().getNavigatorId());
        bidDtoCreate.setCourierId(bid.getCourier().getCourierId());
        bidDtoCreate.setUrgency(bid.getUrgency());
        return bidDtoCreate;
    }

    public BidDtoResponse mapToBidDtoResponse(Bid bid) {
        BidDtoResponse bidDtoResponse = new BidDtoResponse();
        bidDtoResponse.setId(bid.getBidId());
        bidDtoResponse.setNavigator(bid.getNavigator());
        bidDtoResponse.setCourier(bid.getCourier());
        bidDtoResponse.setUrgency(bid.getUrgency());
        return bidDtoResponse;
    }
}
