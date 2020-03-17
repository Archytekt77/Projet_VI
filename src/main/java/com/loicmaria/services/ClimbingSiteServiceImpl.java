package com.loicmaria.services;

import com.loicmaria.entities.ClimbingSite;
import com.loicmaria.repositories.ClimbingSiteRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClimbingSiteServiceImpl implements ClimbingSiteService {
    private static Map<String, ClimbingSite> climbingSiteRepo = new HashMap<>();
    @Override
    public void createClimbingSite(ClimbingSite climbingSite){
        climbingSiteRepo.put(climbingSite.getClimbingSiteId(), climbingSite);
    }
    @Override
    public void updateClimbingSite(String id, ClimbingSite climbingSite){
        climbingSiteRepo.remove(id);
        climbingSite.setClimbingSiteId(id);
        climbingSiteRepo.put(id, climbingSite);
    }
    @Override
    public void deleteClimbingSite(String id){
        climbingSiteRepo.remove(id);
    }
    @Override
    public Collection<ClimbingSite> getClimbingSites(){
        return climbingSiteRepo.values();
    }
}
