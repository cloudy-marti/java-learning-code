package fr.umlv.set;

import java.util.Objects;

public class DynamicHashSet <T> {
    private final int minSize = 8;

    private int numberOfEntries;
    private int hashSetSize;
    private Entry<T>[] hashSet;

    public DynamicHashSet() {
        this.numberOfEntries = 0;
        this.hashSetSize = minSize;
        this.hashSet = new Entry[hashSetSize];
    }

    private void increaseHashSetSize() {
        int hashSetNewSize = hashSetSize * 2;
        Entry<T>[] hashSetTmp = new Entry[hashSetNewSize];

        java.lang.System.arraycopy(hashSet, 0, hashSetTmp, 0, hashSetSize);

        hashSetSize = hashSetNewSize;
        hashSet = hashSetTmp;
    }

    public void add(T element) {
        if(numberOfEntries+1 > hashSetSize)
        {
            increaseHashSetSize();
        }

        int index = element.hashCode() & (hashSetSize - 1);

        Entry pointer = hashSet[index];
        while(pointer != null) {
            if(pointer.value.equals(element)) {
                return;
            }
            pointer = pointer.next;
        }

        hashSet[index] = new Entry(element, hashSet[index]);

        numberOfEntries++;
    }

    public int size() {
        return this.numberOfEntries;
    }



    class Entry <T> {
        private final T value;
        private final Entry<T> next;

        Entry(T value, Entry next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?> entry = (Entry<?>) o;
            return Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
