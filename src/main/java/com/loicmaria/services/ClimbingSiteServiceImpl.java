package com.loicmaria.services;

import com.loicmaria.entities.ClimbingSite;
import com.loicmaria.entities.User;
import com.loicmaria.repositories.ClimbingSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClimbingSiteServiceImpl extends Services<ClimbingSite, ClimbingSiteRepository> {

    @Autowired
    ClimbingSiteRepository climbingSiteRepository;
    @Autowired
    UserServiceImpl userService;

    @Override
    public void add(ClimbingSite climbingSite){
        User user = this.userService.getLoggedUser();
        climbingSite.setUser(user);
        super.add(climbingSite);
    }

    /*
    @Override
    public ClimbingSite update(ClimbingSite climbingSite){
        climbingSite.setUser(climbingSite.getUser());
        return repository.save(climbingSite);
    }*/

    public Collection<ClimbingSite> findByUser_Id(int id) {
        return climbingSiteRepository.findByUser_Id(id);
    }

    public Collection<ClimbingSite> findByNameAndArea(String name, String area){
        return climbingSiteRepository.findByNameAndArea(name,area);
    }
}
