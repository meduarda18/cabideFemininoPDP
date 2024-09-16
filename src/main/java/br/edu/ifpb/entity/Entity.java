package br.edu.ifpb.entity;

import br.edu.ifpb.util.IdGenerator;

public abstract class Entity {

    protected int id;

    public Entity() {
        this.id = IdGenerator.getInstance(this.getClass().getName()).generateId();
    }


}
