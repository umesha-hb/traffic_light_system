package traffic.light.system.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traffic.light.system.dto.SignalRequest;
import traffic.light.system.dto.TrafficStateResponse;
import traffic.light.system.service.TrafficService;

@RestController
@RequestMapping("/traffic")
@RequiredArgsConstructor
public class TrafficController {

    private final TrafficService service;

    @PutMapping("/signal")//this api used updated the Traffic signals for Emergency manually
    public ResponseEntity<Void> updateSignal(@Valid @RequestBody SignalRequest request) {
        service.updateSignal(request);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/state") //Provide the current state and timing history via the API
    public TrafficStateResponse currentState(){
        return service.getCurrentState();
    }
}
