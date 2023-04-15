package vsu.shaforostov.modelingcourierservicework.dto.BidDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vsu.shaforostov.modelingcourierservicework.entity.Courier;
import vsu.shaforostov.modelingcourierservicework.entity.Navigator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BidDtoResponse {

    private Integer id;
    private Navigator navigator;
    private Courier courier;
    private Integer  urgency;
}
