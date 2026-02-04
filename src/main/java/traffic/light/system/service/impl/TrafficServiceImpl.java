package traffic.light.system.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traffic.light.system.dto.SignalRequest;
import traffic.light.system.entity.TrafficLight;
import traffic.light.system.enums.Signal;
import traffic.light.system.exception.ResourceNotFoundException;
import traffic.light.system.repository.TrafficRepository;
import traffic.light.system.service.TrafficService;

@Service
@RequiredArgsConstructor
@Transactional
public class TrafficServiceImpl implements TrafficService {

    private final TrafficRepository repository;

    @Override
    public void updateSignal(SignalRequest request) {

        if (request.getSignal() == Signal.GREEN) {
            repository.findAll().forEach(light -> {
                light.setSignal(Signal.RED);
                repository.save(light);
            });
        }

        TrafficLight light = repository.findByDirection(request.getDirection())
                .orElseThrow(() -> new ResourceNotFoundException("Traffic light not found"));

        light.setSignal(request.getSignal());
        repository.save(light);
    }
}
