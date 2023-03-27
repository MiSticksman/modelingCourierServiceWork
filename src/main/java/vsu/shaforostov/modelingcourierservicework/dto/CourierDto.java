package vsu.shaforostov.modelingcourierservicework.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vsu.shaforostov.modelingcourierservicework.entity.Bid;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourierDto {

    private Integer courierId;
    private List<Bid> bids;

}
