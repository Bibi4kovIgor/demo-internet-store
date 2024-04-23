package edu.lemon.demointernetstore.service;

import java.util.List;

public interface CrudService<T, ID> {

  T create(T object);

  List<T> getAll();

  T getById(ID id);

  T update(T object);

  void deleteById(ID id);
}
