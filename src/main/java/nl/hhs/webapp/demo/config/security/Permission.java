package nl.hhs.webapp.demo.config.security;

import org.springframework.security.core.GrantedAuthority;

public enum Permission implements GrantedAuthority {
    VEHICLE_READ("vehicle:read"),
    VEHICLE_WRITE("vehicle:write"),
    USER_READ("user:read"),
    USER_REGISTER("user:register");

    private final String PERMISSION;

    Permission(String permission) {
        PERMISSION = permission;
    }

    @Override
    public String getAuthority() {
        return PERMISSION;
    }
}
