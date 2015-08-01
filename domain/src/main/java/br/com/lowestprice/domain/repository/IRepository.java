package br.com.lowestprice.domain.repository;

import java.util.List;

/**
 * Created by Gilson Maciel on 01/08/2015.
 */
public interface IRepository<T, ID> {
    public List<T> queryAll();
    public T findById(ID id);
    public void save(T entity);
    public void delete(T entity);
}
