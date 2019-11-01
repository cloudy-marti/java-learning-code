package fr.umlv.seq2;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Seq2<E> implements Iterable<E> {

    private final E[] sequence;
    private final int size;

    private final Function <Object, ? extends E> function;

    @SuppressWarnings("unchecked")
    private Seq2 (List<Object> list, int size) {
        Objects.requireNonNull(list);
        if(list.stream().anyMatch(Objects::isNull)) {
            throw new NullPointerException();
        }
        this.sequence = (E[]) list.toArray();
        this.size = size;

        this.function = e -> (E)e;
    }

    @SuppressWarnings("unchecked")
    private Seq2 (List<Object> list, Function<Object, E> function) {
        Objects.requireNonNull(list);
        if(list.stream().anyMatch(Objects::isNull)) {
            throw new NullPointerException();
        }
        this.sequence = (E[]) list.toArray();
        this.size = list.size();

        this.function = function;
    }

    public static<E> Seq2<E> from(List<? extends E> list) {
        return new Seq2<>(List.copyOf(Objects.requireNonNull(list)), list.size());
    }

    @SafeVarargs
    public static<E> Seq2<E> of(E... elements) {
        return new Seq2<>(Arrays.asList(Objects.requireNonNull(elements)), elements.length);
    }

    public int size() {
        return this.size;
    }

    public E get(int index) {
        return function.apply(sequence[index]);
    }

    public String toString() {
        StringJoiner str = new StringJoiner(", ", "<", ">");
        for(E element : sequence) {
            str.add(function.apply(element).toString());
        }
        return str.toString();
    }

    public void forEach(Consumer<? super E> consumer) {
        Objects.requireNonNull(consumer);
        for(E element : sequence) {
            consumer.accept(function.apply(element));
        }
    }

    public <R>Seq2<R> map(Function<? super E, ? extends R> function) {
        Objects.requireNonNull(function);
        return new Seq2<>(Arrays.asList(this.sequence), this.function.andThen(function));
    }

    public Optional first() {
        return size == 0 ? Optional.empty() : Optional.of(get(0));
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                if(!hasNext()) {
                    throw new NoSuchElementException("not here");
                }

                E tmp = get(index++);

                return tmp;
            }
        };
    }

    private static <U, V> Spliterator<V> mapAndSpliterator(Spliterator<U> spliterator, Function<U, V> mapper) {
        return new Spliterator<V>() {
            @Override
            public boolean tryAdvance(Consumer<? super V> action) {
                Objects.requireNonNull(action);
                return spliterator.tryAdvance(t -> action.accept(mapper.apply(t)));
            }

            @Override
            public Spliterator<V> trySplit() {
                Spliterator<U> tmp = spliterator.trySplit();
                return tmp == null ? null : mapAndSpliterator(tmp, mapper);
            }

            @Override
            public long estimateSize() {
                return spliterator.estimateSize();
            }

            @Override
            public int characteristics() {
                return spliterator.characteristics() | Spliterator.NONNULL | Spliterator.IMMUTABLE;
            }
        };
    }

    @SuppressWarnings("unchecked")
    public Stream<E> stream() {
        Spliterator<E> spliterator = (Spliterator<E>) mapAndSpliterator(Arrays.spliterator(sequence), function);
        return StreamSupport.stream(spliterator, false);
    }
}
