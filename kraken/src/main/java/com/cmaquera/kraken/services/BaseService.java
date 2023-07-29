package com.cmaquera.kraken.services;

public interface BaseService<Entity> {

    Entity create(Entity entity);

    Entity retrieve(Long id);

    Entity update(Entity entity);

    void delete(Long id);

}
