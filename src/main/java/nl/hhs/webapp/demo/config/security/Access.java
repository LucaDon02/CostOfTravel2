package nl.hhs.webapp.demo.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Access {

    @Value("${api.permitted.access}")
    private String[] PERMITTED;

    public String[] permitted() {
        return PERMITTED;
    }
}
