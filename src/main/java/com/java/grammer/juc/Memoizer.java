package com.java.grammer.juc;

import java.util.Map;
import java.util.concurrent.*;

public class Memoizer<A, V> implements Compute<A, V> {

    private final Map<A, FutureTask<V>> cache = new ConcurrentHashMap<>();

    private Compute<A, V> c;

    public Memoizer(Compute<A, V> c){
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if(f == null){
            Callable<V> eval = () -> c.compute(arg);

            FutureTask<V> task = new FutureTask<>(eval);
            f = task;
            cache.putIfAbsent(arg, task); // 高并发必备操作
            task.run();
        }

        try {
            return f.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

interface Compute<A, V>{
    V compute(A arg) throws InterruptedException;
}

class Task implements Compute<String, Integer>{

    @Override
    public Integer compute(String arg) throws InterruptedException {
        return new Integer(arg);
    }
}


