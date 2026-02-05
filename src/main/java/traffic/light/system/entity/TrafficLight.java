package traffic.light.system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import traffic.light.system.enums.Direction;
import traffic.light.system.enums.Signal;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TrafficLight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Direction direction;

    @Enumerated(EnumType.STRING)
    @Column(name = "light_signal")
    private Signal signal;//SIGNAL is a reserved keyword in MySQL.

    private LocalDateTime switchedAt;

    private Long durationSeconds; // how long it stayed active
}