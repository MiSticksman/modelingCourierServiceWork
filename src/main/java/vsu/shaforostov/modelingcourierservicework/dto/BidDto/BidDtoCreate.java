package vsu.shaforostov.modelingcourierservicework.dto.BidDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BidDtoCreate {

    private Integer id;
    private Integer navigatorId;
    private Integer courierId;
    private Integer  urgency;
}
