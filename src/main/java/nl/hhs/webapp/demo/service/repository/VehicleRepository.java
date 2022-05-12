package nl.hhs.webapp.demo.service.repository;

import nl.hhs.webapp.demo.model.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {}
