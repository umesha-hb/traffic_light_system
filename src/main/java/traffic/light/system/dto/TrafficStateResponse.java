package traffic.light.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import traffic.light.system.enums.Direction;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TrafficStateResponse {

    private Direction greenDirection;
    private LocalDateTime since;
}
