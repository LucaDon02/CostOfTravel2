package nl.hhs.webapp.demo.service.dao;

import nl.hhs.webapp.demo.model.vehicle.Vehicle;
import nl.hhs.webapp.demo.service.repository.AbstractRepository;
import nl.hhs.webapp.demo.service.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends AbstractRepository<Vehicle> {

    @Autowired
    public VehicleService(VehicleRepository repository ) {
        super( repository );
    }
}