package com.loicmaria.services;

import com.loicmaria.entities.Topo;
import com.loicmaria.repositories.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TopoServiceImpl implements TopoService {

    @Autowired
    TopoRepository topoRepository;

    @Override
    public void createTopo(Topo topo){
        topoRepository.save(topo);
    }

    @Override
    public void updateTopo(String id, Topo topo){
        topoRepository.findById(id);
        topoRepository.save(topo);
    }

    @Override
    public void deleteTopo(String id){
        topoRepository.deleteById(id);
    }

    @Override
    public Collection<Topo> getTopos(){
        return topoRepository.findAll();
    }
}
