package fr.umlv.xl;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Calc<E> {

    private final HashMap<String, Supplier<? extends E>> hashMap = new HashMap<>();

    public void set(String name, Supplier<? extends E> supplier) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(supplier);

        this.hashMap.put(name, supplier);
    }

    public Optional<E> eval(String name) {
        Objects.requireNonNull(name);

        return Optional.ofNullable(this.hashMap.get(name)).map(Supplier::get);
    }

    @Override
    public String toString() {
        StringJoiner str = new StringJoiner(", ", "{", "}");

        hashMap.forEach((name, value) -> {
            str.add(name + "=" + value.get());
        });

        return str.toString();
    }

    public void forEach(BiConsumer<? super String, ? super E> biConsumer) {
        Objects.requireNonNull(biConsumer);
        hashMap.forEach((name, value) -> biConsumer.accept(name, value.get()));
    }

    @FunctionalInterface
    public interface Group<T> {
        public Stream<T> values();

        @SafeVarargs
        public static<V> Group<V> of(V... args) {
            Objects.requireNonNull(args);
            for(V arg : args) {
                Objects.requireNonNull(arg);
            }

            V[] array = Arrays.copyOf(args, args.length);
            return () -> Stream.of(array);
        }

        public default void forEach(Consumer<? super T> consumer) {
            Objects.requireNonNull(consumer);
            values().forEach(consumer);
        }

        public static Group<String> cellMatrix(int startRow, int endRow, char startCol, char endCol) {
            if(startRow > endRow || startCol > endCol) {
                throw new IllegalArgumentException("Start point cannot be higher than end point");
            }

            List<String> list = new ArrayList<>();
            for(int i = startCol; i <= endCol; ++i) {
                for(int j = startRow; j <= endRow; ++j) {
                    list.add(String.valueOf((char)i) + j);
                }
            }

            return list::stream;
        }

        public default Group<T> ignore(Set<? super T> set) {
            Objects.requireNonNull(set);
            return () -> this.values().filter(value -> !set.contains(value));
        }

        public default<E> Stream<E> eval(Function<T, Optional<E>> function) {
            Objects.requireNonNull(function);
            return values().flatMap(value -> function.apply(value).stream());
        }
    }
}