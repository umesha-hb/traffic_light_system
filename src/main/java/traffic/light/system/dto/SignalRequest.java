package traffic.light.system.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import traffic.light.system.enums.Direction;
import traffic.light.system.enums.Signal;

@Data
public class SignalRequest {

    @NotNull
    private Direction direction;

    @NotNull
    @JsonProperty("lightSignal")
    private Signal signal;
}
