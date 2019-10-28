package fr.umlv.seq;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Seq<E> {

    private final ArrayList<Object> sequence;
    private final int size;

    private final Function <Object, E> function;

    private Seq (List<Object> list, int size) {
        Objects.requireNonNull(list);
        if(list.stream().anyMatch(e -> e == null)) {
            throw new NullPointerException();
        }
        this.sequence = new ArrayList<>(list);
        this.size = size;

        this.function = e -> (E)e;
    }

    private Seq (List<Object> list, Function<Object, E> function) {
        Objects.requireNonNull(list);
        if(list.stream().anyMatch(e -> e == null)) {
            throw new NullPointerException();
        }
        this.sequence = new ArrayList(list);
        this.size = list.size();

        this.function = function;
    }

    public static Seq from(List list) {
        return new Seq(list, list.size());
    }

    @SafeVarargs
    public static<E> Seq of(E... elements) {
        return new Seq(Arrays.asList(elements), elements.length);
    }

    public int size() {
        return this.size;
    }

    public E get(int index) {
        return function.apply(sequence.get(index));
    }

    public String toString() {
        StringJoiner str = new StringJoiner(", ", "<", ">");
        sequence.forEach(element -> str.add(element.toString()));

        return str.toString();
    }

    public void forEach(Consumer<? super E> consumer) {
        sequence.forEach(e -> consumer.accept(function.apply(e)));
    }

    public <R>Seq<R> map(Function<? super E, ? extends R> function) {
        Objects.requireNonNull(function);

        return new Seq<R>(this.sequence, this.function.andThen(function));
    }
}
