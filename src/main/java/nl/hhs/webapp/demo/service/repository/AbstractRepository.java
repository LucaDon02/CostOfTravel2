package nl.hhs.webapp.demo.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractRepository<T> {

    protected final JpaRepository<T,Long> REPOSITORY;

    protected AbstractRepository(JpaRepository<T,Long> repository) {
        REPOSITORY = repository;
    }

    public void
    save( T entity ) {
        REPOSITORY.save( entity );
    }

    public void
    delete( Long... entityIDs ) {
        REPOSITORY.deleteAllById(List.of(entityIDs));
    }

    public T
    getById( Long entityID) {
        return REPOSITORY.getById(entityID);
    }

    public List<T>
    getAll() {
        return REPOSITORY.findAll();
    }
}

