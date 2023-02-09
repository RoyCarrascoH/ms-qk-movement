package nttdata.bootcamp.quarkus.movement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Cacheable
@Table(name = "MOVEMENTS")
public class MovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovement;
    private String account;
    private int numberMovement;
    private String movementType;
    private double amount;
    private String movementDate;
}