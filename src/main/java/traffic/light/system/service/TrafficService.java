package traffic.light.system.service;


import traffic.light.system.dto.SignalRequest;

public interface TrafficService {
    void updateSignal(SignalRequest request);
}
