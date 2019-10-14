package fr.umlv.set;

import java.util.function.IntConsumer;

public class IntHashSet {
    private int size;
    private final Entry[] hashSet;

    public IntHashSet() {
        this.size = 0;
        this.hashSet = new Entry[8];
    }

    /*
    private int hashFunctionEvenAndUneven(int value) {
        return value & 1;
    }

    private int hashFunctionEight(int value) {
        return value & 7;
    }
     */

    private int hashFunction(int value) {
        return value & (hashSet.length - 1);
    }

    public void add(int value) {
        int index = hashFunction(value);

        Entry pointer = hashSet[index];
        while(pointer != null) {
            if(pointer.value == value) {
                return;
            }
            pointer = pointer.next;
        }

        hashSet[index] = new Entry(value, hashSet[index]);

        size++;
    }

    public int size()
    {
        return this.size;
    }

    public void forEach(IntConsumer function) {
        for(Entry entry : hashSet) {
            while (entry != null) {
                function.accept(entry.value);
                entry = entry.next;
            }
        }
    }

    public boolean contains(int value) {
        int index = hashFunction(value);
        Entry pointer = hashSet[index];

        while(pointer != null) {
            if(pointer.value == value) {
                return true;
            }
        }
        return false;
    }

    class Entry {
        private final int value;
        private final Entry next;

        Entry(int value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
