package fr.umlv.seq;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Seq<E> implements Iterable<E> {

    private final ArrayList<Object> sequence;
    private final int size;

    private final Function <Object, ? extends E> function;

    @SuppressWarnings("unchecked")
    private Seq (List<Object> list, int size) {
        Objects.requireNonNull(list);
        if(list.stream().anyMatch(Objects::isNull)) {
            throw new NullPointerException();
        }
        this.sequence = new ArrayList<>(list);
        this.size = size;

        this.function = e -> (E)e;
    }

    private Seq (List<Object> list, Function<Object, E> function) {
        Objects.requireNonNull(list);
        if(list.stream().anyMatch(Objects::isNull)) {
            throw new NullPointerException();
        }
        this.sequence = new ArrayList<>(list);
        this.size = list.size();

        this.function = function;
    }

    public static<E> Seq<E> from(List<? extends E> list) {
        return new Seq<>(List.copyOf(Objects.requireNonNull(list)), list.size());
    }

    @SafeVarargs
    public static<E> Seq<E> of(E... elements) {
        return new Seq<>(Arrays.asList(Objects.requireNonNull(elements)), elements.length);
    }

    public int size() {
        return this.size;
    }

    public E get(int index) {
        return function.apply(sequence.get(index));
    }

    public String toString() {
        StringJoiner str = new StringJoiner(", ", "<", ">");
        sequence.forEach(element -> str.add(function.apply(element).toString()));
        return str.toString();
    }

    public void forEach(Consumer<? super E> consumer) {
        Objects.requireNonNull(consumer);
        sequence.forEach(e -> consumer.accept(function.apply(e)));
    }

    public <R>Seq<R> map(Function<? super E, ? extends R> function) {
        Objects.requireNonNull(function);
        return new Seq<>(this.sequence, this.function.andThen(function));
    }

    public Optional findFirst() {
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
        Spliterator<E> spliterator = (Spliterator<E>) mapAndSpliterator(sequence.spliterator(), function);
        return StreamSupport.stream(spliterator, false);
    }
}
