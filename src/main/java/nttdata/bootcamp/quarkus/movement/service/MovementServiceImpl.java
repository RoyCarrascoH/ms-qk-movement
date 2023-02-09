package nttdata.bootcamp.quarkus.movement.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import nttdata.bootcamp.quarkus.movement.entity.MovementEntity;
import nttdata.bootcamp.quarkus.movement.repository.MovementRepository;

import java.util.List;

@ApplicationScoped
public class MovementServiceImpl implements  MovementService{

    @Inject
    MovementRepository repository;
    @Override
    public List<MovementEntity> listAll() {
        return repository.listAll();
    }
    @Override
    public MovementEntity findById(Long id) {
        return repository.findById(id);
    }
    @Override
    public void save(MovementEntity movement) {
                repository.persist(movement);
    }
    @Override
    public MovementEntity update(Long id, MovementEntity movement) {
                repository.persist(movement);
        return movement;
    }
    @Override
    public void delete(Long id) {
                repository.deleteById(id);
    }
}