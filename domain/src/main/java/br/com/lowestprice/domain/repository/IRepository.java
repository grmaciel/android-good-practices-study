package br.com.lowestprice.domain.repository;

import java.util.List;

import rx.Observable;

/**
 * Created by Gilson Maciel on 01/08/2015.
 */
public interface IRepository<T, ID> {
    public Observable<List<T>> queryAll();
    public Observable<T> findById(ID id);
    public void save(T entity);
    public void delete(T entity);
}
