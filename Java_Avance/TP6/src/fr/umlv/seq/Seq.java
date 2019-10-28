package fr.umlv.seq;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Seq<E> {

    private final ArrayList<E> sequence;
    private final int size;

    private ArrayList<E> mappedSequence;

    private Seq (List<E> list, int size) {
        Objects.requireNonNull(list);
        if(list.stream().anyMatch(e -> e == null)) {
            throw new NullPointerException();
        }
        this.sequence = new ArrayList<>(list);
        this.size = size;
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
        return sequence.get(index);
    }

    public String toString() {
        StringJoiner str = new StringJoiner(", ", "<", ">");
        sequence.forEach(element -> str.add(element.toString()));

        return str.toString();
    }

    public void forEach(Consumer<E> consumer) {
        sequence.forEach(consumer::accept);
    }

    public Seq<E> map(Function<E, E> function) {
        return new Seq<>(sequence, size);
    }
}
