package vsu.shaforostov.modelingcourierservicework.mapper;

import org.springframework.stereotype.Component;
import vsu.shaforostov.modelingcourierservicework.dto.BidDto;
import vsu.shaforostov.modelingcourierservicework.entity.Bid;


@Component
public class BidMapper {

    public Bid mapToBidEntity(BidDto bidDto) {
        Bid bid = new Bid();
        bid.setBidId(bidDto.getBidId());
        bid.setNavigator(bidDto.getNavigator());
        bid.setUrgency(bidDto.getUrgency());
        return bid;
    }

    public BidDto mapToBidDto(Bid bid) {
        BidDto bidDto = new BidDto();
        bidDto.setBidId(bid.getBidId());
        bidDto.setNavigator(bid.getNavigator());
        bidDto.setUrgency(bid.getUrgency());
        return bidDto;
    }
}
