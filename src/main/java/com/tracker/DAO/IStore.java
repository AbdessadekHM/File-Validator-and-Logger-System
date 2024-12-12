package com.tracker.DAO;

import java.util.List;

public interface IStore<T> {
   public void add(List<T> list);
   public T get();
   public void update(T element);
   public T delete(T element); // return the deleted element

}