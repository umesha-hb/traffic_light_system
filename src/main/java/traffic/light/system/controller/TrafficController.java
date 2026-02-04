package traffic.light.system.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traffic.light.system.dto.SignalRequest;
import traffic.light.system.service.TrafficService;

@RestController
@RequestMapping("/traffic")
@RequiredArgsConstructor
public class TrafficController {

    private final TrafficService service;

    @PutMapping("/signal")
    public ResponseEntity<Void> updateSignal(@Valid @RequestBody SignalRequest request) {
        service.updateSignal(request);
        return ResponseEntity.ok().build();
    }
}
