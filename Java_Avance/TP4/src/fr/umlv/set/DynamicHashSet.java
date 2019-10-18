package fr.umlv.set;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

public class DynamicHashSet <T> {
    private final int minSize = 8;

    private int numberOfEntries;
    private int hashSetSize;
    private Entry<T>[] hashSet;

    public DynamicHashSet() {
        this.numberOfEntries = 0;
        this.hashSetSize = minSize;
        this.hashSet = (Entry<T>[]) new Entry[hashSetSize];
    }

    private void increaseHashSetSize() {
        int hashSetNewSize = hashSetSize * 2;
        Entry<T>[] hashSetTmp = (Entry<T>[]) new Entry[hashSetNewSize];

        this.forEach(value -> add(value, hashSetTmp));

        hashSetSize = hashSetNewSize;
        hashSet = hashSetTmp;
    }

    private boolean add(T element, Entry<T>[] hashSetMap) {
        int index = element.hashCode() & (hashSetSize - 1);

        Entry pointer = hashSetMap[index];
        while(pointer != null) {
            if(pointer.value.equals(element)) {
                return false;
            }
            pointer = pointer.next;
        }

        hashSetMap[index] = new Entry(element, hashSetMap[index]);
        return true;
    }

    public void add(T element) {
        if(numberOfEntries+1 > hashSetSize / 2) {
            increaseHashSetSize();
        }

        if(add(element, hashSet)) {
            numberOfEntries++;
        }
    }

    public int size() {
        return this.numberOfEntries;
    }

    public void forEach(Consumer<? super T> function) {
        Objects.requireNonNull(function);

        for(Entry<T> entry : hashSet) {
            Entry<T> tmp = entry;
            while (tmp != null) {
                function.accept(entry.value);
                tmp = tmp.next;
            }
        }
    }

    public boolean contains(T element) {
        int index = element.hashCode() & (hashSetSize - 1);

        Entry<T> pointer = hashSet[index];

        while(pointer != null) {
            if(pointer.value.equals(element)) {
                return true;
            }
            pointer = pointer.next;
        }

        return false;
    }

    public void addAll(Collection<? extends T> collection) {
        for(T element : collection) {
            add(element);
        }
    }


    class Entry <E> {
        private final E value;
        private final Entry<E> next;

        Entry(E value, Entry<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String args[]) {
        var set = new DynamicHashSet<Integer>();
        set.add(3);
        System.out.println("Size =" + set.size());
        set.add(-777);
        System.out.println("Size =" + set.size());
        set.add(3);
        System.out.println("Size =" + set.size());
        set.add(-777);
        System.out.println("Size =" + set.size());
    }
}
