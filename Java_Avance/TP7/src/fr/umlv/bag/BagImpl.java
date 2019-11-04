package fr.umlv.bag;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class BagImpl<T> implements Bag<T> {
    private final Map<T, Integer> hashMap;
    private int size;

    public BagImpl(Map<T, Integer> map) {
        this.hashMap = map;
    }

    @Override
    public int add(T element, int count) {
        Objects.requireNonNull(element);

        if(count <= 0) {
            throw new IllegalArgumentException("wrong counter");
        }

        size += count;

        return hashMap.compute(element, (key, value) -> value == null ? count : value + count);
    }

    @Override
    public int count(Object element) {
        Objects.requireNonNull(element);

        return hashMap.getOrDefault(element, 0);
    }

    @Override
    public void forEach(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer);

        hashMap.forEach((key, value) -> {
            for(int i = 0; i < value; ++i) {
                consumer.accept(key);
            }
        });
    }

    public Iterator<T> iterator2() {
        ArrayDeque<T> deque = new ArrayDeque<>();

        hashMap.forEach((key, value) -> {
            IntStream.range(0, value).forEach(index -> {
                deque.offerLast(key);
            });
        });

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !deque.isEmpty();
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                return deque.pollFirst();
            }
        };
    }

    @Override
    public Iterator<T> iterator() {
        return hashMap.entrySet().stream()
                .flatMap(entry -> Collections.nCopies(entry.getValue(), entry.getKey()).stream())
                .iterator();
    }

    @Override
    public AbstractCollection<T> asCollection() {
        Iterator<T> iterator = iterator();
        Supplier<Iterator<T>> function = this::iterator2;

        return new AbstractCollection<T>() {
            @Override
            public Iterator<T> iterator() {
                return iterator;
            }

            /**
             * Another way to implement iterator
             */
            public Iterator<T> iterator2() {
                return function.get();
            }

            @Override
            public int size() {
                return size;
            }
        };
    }
}
