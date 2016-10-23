package br.com.uniCad.dao;

import java.util.List;

import br.com.uniCad.beans.AbstractBean;

public interface Crud<T> {
	public int insert(T bean);
	public void update(T bean);
	public List<T> list();
	public T getById(int id);
	public void delete(int id);
}
