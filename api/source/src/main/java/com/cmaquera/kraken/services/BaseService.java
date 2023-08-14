package com.cmaquera.kraken.services;

import java.util.List;

public interface BaseService<Entity> {

    Entity create(Entity entity);

    Entity getById(Long id);

    List<Entity> getAll();

    Entity update(Entity entity);

    void delete(Long id);

}
