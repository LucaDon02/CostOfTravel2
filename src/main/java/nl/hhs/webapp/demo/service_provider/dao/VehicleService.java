package nl.hhs.webapp.demo.service_provider.dao;

import nl.hhs.webapp.demo.model.vehicle.Vehicle;
import nl.hhs.webapp.demo.service_provider.repository.AbstractRepository;
import nl.hhs.webapp.demo.service_provider.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends AbstractRepository<Vehicle> {

    @Autowired
    public VehicleService(VehicleRepository repository ) {
        super( repository );
    }

//    @Override
//    public void save(Vehicle entity) {
//        //        do some checks
//        super.save(entity);
//    }
}