package nl.hhs.webapp.demo.config.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static nl.hhs.webapp.demo.config.security.Permission.VEHICLE_READ;
import static nl.hhs.webapp.demo.config.security.Permission.VEHICLE_WRITE;

public enum Roles {
    USER(Sets.newHashSet(VEHICLE_READ, VEHICLE_WRITE)), ADMIN(Sets.newHashSet(Permission.values()));

    private final Set<Permission> PERMISSIONS;


    Roles(Set<Permission> permissions) {
        PERMISSIONS = permissions;
    }

    public Set<Permission> getPermissions() {
        return PERMISSIONS;
    }
}