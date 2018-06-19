package com.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

	// List a list of objects
	public List<T> getAll();

	// return single object given its id
	public Optional<T> get(int id);

	// add item obj into database
	public void add(T obj);

	// update item
	public void update(T obj);

	// delete item given id
	public void delete(int id);
}
