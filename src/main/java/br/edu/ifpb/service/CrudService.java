package br.edu.ifpb.service;

import java.util.List;

public interface CrudService <Type, ID> {

    public Type add(Type item);

    public void remove(ID id);

    public List<Type> list();

    public Type update(ID id);

}
