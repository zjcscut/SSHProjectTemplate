package cn.zjcscut.extra;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangjinci
 * @version 2016/7/12 14:09
 */

/**
 * ConcurrentHashSet的实现
 *
 * @param <E>
 */
public class ConcurrentHashSet<E> extends AbstractSet<E> implements Set<E> {

    private final Map<E, Boolean> map;

    private transient Set<E> keys;

    public ConcurrentHashSet() {
        this.map = new ConcurrentHashMap<>();
        this.keys = map.keySet();
    }

    public ConcurrentHashSet(int initialCapacity) {
        this.map = new ConcurrentHashMap<>(initialCapacity);
        this.keys = map.keySet();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Object[] toArray() {
        return keys.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return keys.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, Boolean.TRUE) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return keys.containsAll(c);
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return keys.containsAll(c);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        return keys.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return keys.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public int hashCode() {
        return keys.hashCode();
    }
}
