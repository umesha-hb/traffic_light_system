package traffic.light.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import traffic.light.system.entity.TrafficLight;
import traffic.light.system.enums.Direction;

import java.util.Optional;

public interface TrafficRepository extends JpaRepository<TrafficLight, Long> {

    Optional<TrafficLight> findByDirection(Direction direction);
}
