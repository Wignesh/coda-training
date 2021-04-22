package ga.veee.shopping.Repository;


import ga.veee.shopping.DAO.DAO;
import ga.veee.shopping.Utility.HibernateUtility;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class Repository<T> implements Cloneable, Serializable, DAO<T, Integer> {

    private final Class<T> type;

    protected Repository(Class<T> type) {
        this.type = type;
    }

    @Override
    public Optional<T> findById(Integer id) {
        T t = null;
        try {
            Session session = HibernateUtility.getSession();
            t = Objects.requireNonNull(session).find(type, id);
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtility.closeSession(e);
        } finally {
            HibernateUtility.closeSession(null);
        }
        return Optional.ofNullable(t);
    }

    @Override
    public Iterable<T> findAll() {
        List<T> ts = null;
        try {
            Session session = HibernateUtility.getSession();
            ts = Objects.requireNonNull(session).createQuery(String.format("from %s", type.getSimpleName()), type).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtility.closeSession(e);
        } finally {
            HibernateUtility.closeSession(null);
        }
        return ts;
    }

    @Override
    public Iterable<T> findAllById(Iterable<Integer> ids) {
        List<T> ts = new ArrayList<>();
        try {
            Session session = HibernateUtility.getSession();
            for (Integer id : ids) {
                ts.add(Objects.requireNonNull(session).find(type, id));
            }
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtility.closeSession(e);
        } finally {
            HibernateUtility.closeSession(null);
        }
        return ts;
    }

    @Override
    public boolean existById(Integer id) {
        Optional<T> find = findById(id);
        return find.isPresent();
    }

    @Override
    public long count() {
        long result = 0;
        try {
            Session session = HibernateUtility.getSession();
            result = (Long) Objects.requireNonNull(session).createQuery(String.format("select count(*) from %s ", type.getSimpleName())).
                    uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtility.closeSession(e);
        } finally {
            HibernateUtility.closeSession(null);
        }
        return result;
    }

    @Override
    public Integer insert(T t) {
        Integer result;
        try {
            Session session = HibernateUtility.getSession();
            result = (Integer) Objects.requireNonNull(session).save(t);
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
            HibernateUtility.closeSession(e);
        } finally {
            HibernateUtility.closeSession(null);
        }
        return result;
    }

    @Override
    public Iterable<Integer> insertAll(Iterable<T> ts) {
        List<Integer> ids = new ArrayList<>();
        for (T t : ts) {
            ids.add(insert(t));
        }
        return ids;
    }

    @Override
    public Integer update(T t) {
        int result = 0;
        try {
            Session session = HibernateUtility.getSession();
            Objects.requireNonNull(session).merge(t);
            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtility.closeSession(e);
            return -1;
        } finally {
            int close = HibernateUtility.closeSession(null);
            result = close <= 0 ? close : result;
        }
        return result;
    }

    @Override
    public Integer update(T t, Integer id) {
        Optional<T> find = findById(id);
        if (find.isPresent()) {
            return update(t);
        }
        return 0;
    }

    @Override
    public Integer deleteById(Integer id) {
        int result = 0;
        try {
            Session session = HibernateUtility.getSession();
            T t = Objects.requireNonNull(session).find(type, id);
            if (t != null) {
                Objects.requireNonNull(session).delete(t);
                result = 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtility.closeSession(e);
            return -1;
        } finally {
            int close = HibernateUtility.closeSession(null);
            result = close <= 0 ? close : result;
        }
        return result;
    }

    @Override
    public Integer delete(T t) {
        int result = 0;
        try {
            Session session = HibernateUtility.getSession();
            if (t != null) {
                Objects.requireNonNull(session).delete(t);
                result = 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtility.closeSession(e);
            return -1;
        } finally {
            int close = HibernateUtility.closeSession(null);
            result = close <= 0 ? close : result;
        }
        return result;
    }

    @Override
    public Iterable<Integer> deleteAll(Iterable<T> ts) {
        List<Integer> results = new ArrayList<>();
        for (T t : ts) {
            results.add(delete(t));
        }
        return results;
    }

    @Override
    public Iterable<Integer> deleteAllById(Iterable<Integer> ids) {
        List<Integer> results = new ArrayList<>();
        for (Integer id : ids) {
            results.add(deleteById(id));
        }
        return results;
    }

    @Override
    public Integer deleteAll() {
        int result = 0;
        try {
            Session session = HibernateUtility.getSession();
            Objects.requireNonNull(session).createQuery(String.format("delete from %s", type.getSimpleName())).executeUpdate();
            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtility.closeSession(e);
            return -1;
        } finally {
            int close = HibernateUtility.closeSession(null);
            result = close <= 0 ? close : result;
        }
        return result;
    }

}
