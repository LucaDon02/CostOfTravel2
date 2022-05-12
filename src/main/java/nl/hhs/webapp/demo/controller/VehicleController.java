package nl.hhs.webapp.demo.controller;

import nl.hhs.webapp.demo.model.vehicle.Vehicle;
import nl.hhs.webapp.demo.service.dao.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class VehicleController {

    final VehicleService VEHICLE_SERVICE;

    @Autowired
    public VehicleController( VehicleService vehicle_service ) {
        VEHICLE_SERVICE = vehicle_service;
    }

    @PostMapping("${api.post.vehicle}") public void
    addVehicle(
            @RequestBody Vehicle vehicle
    ) {
        VEHICLE_SERVICE.save( vehicle );
    }
}

////The 422 (Unprocessable Entity) status code means the server understands the content type of the request entity (hence a
////415 (Unsupported Media Type) status code is inappropriate), and the syntax of the request entity is correct (thus a
////400 (Bad Request) status code is inappropriate) but was unable to process the contained instructions. For example,
////this error condition may occur if an XML request body contains well-formed (i.e., syntactically correct), but semantically erroneous, XML instructions.