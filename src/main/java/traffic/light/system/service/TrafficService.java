package traffic.light.system.service;


import traffic.light.system.dto.SignalRequest;
import traffic.light.system.dto.TrafficStateResponse;

public interface TrafficService {
    void updateSignal(SignalRequest request);

    TrafficStateResponse getCurrentState();
}
