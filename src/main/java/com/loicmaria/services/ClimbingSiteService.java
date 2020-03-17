package com.loicmaria.services;

import com.loicmaria.entities.ClimbingSite;

import java.util.Collection;

public interface ClimbingSiteService {
    public abstract void createClimbingSite(ClimbingSite climbingSite);
    public abstract void updateClimbingSite(String id, ClimbingSite climbingSite);
    public abstract void deleteClimbingSite(String id);
    public abstract Collection<ClimbingSite> getClimbingSites();
}
