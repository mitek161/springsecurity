package com.example.SpringSecurityThird.model;

import java.util.Set;

public enum Role {
    ADMIN(Set.of(Permission.READ, Permission.WRITE)),
    USER(Set.of(Permission.READ));

    private final Set<Permission> permission;

    Role(Set<Permission> permission) {
        this.permission = permission;
    }

    public Set<Permission> getPermission() {
        return permission;
    }

}
