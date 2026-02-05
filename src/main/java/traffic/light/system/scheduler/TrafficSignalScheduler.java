package traffic.light.system.scheduler;


import traffic.light.system.enums.Direction;
import traffic.light.system.enums.Signal;
import traffic.light.system.repository.TrafficRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumSet;

@Component
@RequiredArgsConstructor
@Slf4j
public class TrafficSignalScheduler {

    private final TrafficRepository repository;

    // Runs every 60 seconds
    @Scheduled(fixedRateString = "${traffic.scheduler.rotation-time:60000}")
    @Transactional
    public void rotateSignals() {

        log.info("⏱ Auto traffic signal rotation started");

        boolean isNorthSouthGreen = isAnyGreen(EnumSet.of(
                Direction.NORTH, Direction.SOUTH
        ));

        if (isNorthSouthGreen) {
            switchToEastWest();
        } else {
            switchToNorthSouth();
        }

        log.info("✅ Traffic signal rotation completed");
    }

    private boolean isAnyGreen(EnumSet<Direction> directions) {
        return repository.findAll().stream()
                .anyMatch(light ->
                        directions.contains(light.getDirection())
                                && light.getSignal() == Signal.GREEN);
    }

    private void switchToNorthSouth() {

        log.info("🚦 Switching GREEN → NORTH & SOUTH");

        repository.findAll().forEach(light -> {
            if (light.getDirection() == Direction.NORTH
                    || light.getDirection() == Direction.SOUTH) {
                light.setSignal(Signal.GREEN);
            } else {
                light.setSignal(Signal.RED);
            }
        });
    }

    private void switchToEastWest() {

        log.info("🚦 Switching GREEN → EAST & WEST");

        repository.findAll().forEach(light -> {
            if (light.getDirection() == Direction.EAST
                    || light.getDirection() == Direction.WEST) {
                light.setSignal(Signal.GREEN);
            } else {
                light.setSignal(Signal.RED);
            }
        });
    }
}
