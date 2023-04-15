package vsu.shaforostov.modelingcourierservicework.dto.NavigatorDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NavigatorDtoCreate {
    private Integer id;
    private Integer fromId;
    private Integer toId;
    private Integer timeFromTo;
}
