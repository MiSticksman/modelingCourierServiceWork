package vsu.shaforostov.modelingcourierservicework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vsu.shaforostov.modelingcourierservicework.entity.Bid;
import vsu.shaforostov.modelingcourierservicework.entity.Branch;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NavigatorDto {
    private Integer navigatorId;

    private Branch  from;
    private Branch  to;
    private Integer timeFromTo;
}
