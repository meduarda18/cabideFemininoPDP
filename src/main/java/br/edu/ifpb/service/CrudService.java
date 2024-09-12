package br.edu.ifpb.service;

import java.util.List;

public interface CrudService <Type, ID> {

    public void add(Type item);

    public boolean remove(ID id);

    public List<Type> list();

    public boolean update(ID id, Type item);

    public Type searchID(ID id);
}
