package fr.umlv.matrix;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

class MatrixGraph<T> implements Graph<T> {

    private final int nodeCount;
    private final T[] nodes;

    @SuppressWarnings("unchecked")
    MatrixGraph(int nodeCount) {
        if(nodeCount < 0) {
            throw new IllegalArgumentException("nodeCount only positive");
        }
        this.nodeCount = nodeCount;
        this.nodes = (T[])new Object[nodeCount*nodeCount];
    }

    private void isInBound(int index) {
        if(index < 0 || index >= nodeCount) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Optional<T> getWeight(int src, int dst) {
        isInBound(src);
        isInBound(dst);
        return Optional.ofNullable(nodes[src*nodeCount + dst]);
    }

    @Override
    public void addEdge(int src, int dst, T weight) {
        Objects.requireNonNull(weight);
        isInBound(src);
        isInBound(dst);
        this.nodes[src*nodeCount + dst] = weight;
    }

    @Override
    public void edges(int src, EdgeConsumer<? super T> consumer) {
        Objects.requireNonNull(consumer);
        isInBound(src);
        for(int i = src; i < nodeCount; i++) {
            isInBound(i);
            if(getWeight(src, i).isPresent()) {
                consumer.edge(src, i, getWeight(src, i).orElseThrow());
            }
        }
    }

    @Override
    public Iterator<Integer> neighborIterator(int src) {
        isInBound(src);
        return new Iterator<>() {
            private int index = nextValidArc(0);
            private Integer dst = null;

            @Override
            public boolean hasNext() {
                return index < nodeCount;
            }

            private int nextValidArc(int source) {
                for(int i = source; i < nodeCount; i++) {
                    if(nodes[src*nodeCount + i] != null) {
                        return i;
                    }
                }
                return nodeCount;
            }

            @Override
            public Integer next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer indexInteger = index;
                dst = indexInteger;
                index = nextValidArc(index+1);
                return indexInteger;
            }

            @Override
            public void remove() {
                if(dst == null) {
                    throw new IllegalStateException("no elements to remove");
                }
                nodes[src*nodeCount + dst] = null;
                dst = null;
            }
        };
    }
}