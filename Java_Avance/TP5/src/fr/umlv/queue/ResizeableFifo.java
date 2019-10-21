package fr.umlv.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

public class ResizeableFifo<E> implements Iterable<E> {
    private E[] fifo;
    private int size;

    private int head;
    private int tail;

    private int nbOfElements;

    @SuppressWarnings("unchecked")
    public ResizeableFifo(int size) {
        Objects.requireNonNull(size);

        if(size <= 0) {
            throw new IllegalArgumentException("Size has to be higher than 0");
        }

        this.size = size;
        fifo = (E[]) new Object[size];
        head = tail = nbOfElements = 0;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        int newSize = size*2;
        E[] tmpFifo = (E[]) new Object[newSize];

        System.arraycopy(fifo, head, tmpFifo, 0, nbOfElements);

        size = newSize;
        fifo = tmpFifo;
        head = 0;
        tail = nbOfElements;
    }

    public void offer(E element) {
        Objects.requireNonNull(element);

        if(nbOfElements == size) {
            grow();
        }
        fifo[tail] = element;

        tail = (tail+1)%size;
        nbOfElements += 1;
    }

    private boolean fifoIsEmpty() {
        if(nbOfElements == 0) {
            return true;
        }
        return false;
    }

    public E poll() {
        if(fifoIsEmpty()) {
            throw new IllegalStateException("Fifo is empty");
        }

        E tmp = fifo[head];

        fifo[head] = null;

        head = (head+1)%size;
        nbOfElements -= 1;

        return tmp;
    }

    @Override
    public String toString() {
        StringJoiner str = new StringJoiner(", ", "[", "]");

        for(int index = 0; index < nbOfElements ; index++) {
            str.add(fifo[(head+index)%size].toString());
        }

        return str.toString();
    }

    public int size() {
        return this.nbOfElements;
    }

    public boolean isEmpty() {
        return fifoIsEmpty();
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter != nbOfElements;
            }

            @Override
            public E next() {
                if(!hasNext()) {
                    throw new NoSuchElementException("not here");
                }

                E tmp = fifo[index];
                index = (index+1)%size;
                counter++;

                return tmp;
            }
        };
    }
}
