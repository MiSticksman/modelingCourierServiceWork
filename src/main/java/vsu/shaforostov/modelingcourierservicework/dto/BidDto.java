package vsu.shaforostov.modelingcourierservicework.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vsu.shaforostov.modelingcourierservicework.entity.Navigator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BidDto {

    private Integer bidId;
    private Navigator navigator;
    private Integer  urgency;
}
