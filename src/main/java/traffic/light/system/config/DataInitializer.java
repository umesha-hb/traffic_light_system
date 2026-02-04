package traffic.light.system.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import traffic.light.system.entity.TrafficLight;
import traffic.light.system.enums.Direction;
import traffic.light.system.enums.Signal;
import traffic.light.system.repository.TrafficRepository;


@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final TrafficRepository repository;


    @Override
    public void run(String... args) {

        // Prevent duplicate inserts
        if(repository.count() > 0){
            return;
        }

        for(Direction direction : Direction.values()){

            TrafficLight light = new TrafficLight();
            light.setDirection(direction);
            light.setSignal(Signal.RED);

            repository.save(light);
        }
        System.out.println("Traffic lights initialized");
    }
}
