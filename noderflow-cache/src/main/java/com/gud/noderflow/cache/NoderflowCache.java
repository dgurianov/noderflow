package com.gud.noderflow.cache;

import java.util.List;

public interface NoderflowCache<T> {

   public void put(String key , T element);

   public T get(String key);

   public List<T> getAll();

   public List<T> getTwoRandom();

}
