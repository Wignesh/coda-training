package ga.veee.shopping.DAO;

import java.util.Optional;

public interface DAO<T, ID> {

    Optional<T> findById(ID id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> ids);

    boolean existById(ID id);

    long count();

    ID insert(T item);

    Iterable<ID> insertAll(Iterable<T> items);

    ID update(T item);

    ID update(T item, ID id);

    ID deleteById(ID id);

    ID delete(T item);

    Iterable<ID> deleteAll(Iterable<T> items);

    Iterable<ID> deleteAllById(Iterable<ID> id);

    ID deleteAll();

}