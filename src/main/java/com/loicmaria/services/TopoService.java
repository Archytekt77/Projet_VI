package com.loicmaria.services;

import com.loicmaria.entities.Topo;

import java.util.Collection;

public interface TopoService {
    public abstract void createTopo(Topo topo);
    public abstract void updateTopo(String id, Topo topo);
    public abstract void deleteTopo(String id);
    public abstract Collection<Topo> getTopos();
}
