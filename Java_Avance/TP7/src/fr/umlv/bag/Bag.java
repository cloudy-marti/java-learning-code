package fr.umlv.bag;

import java.util.*;
import java.util.function.Consumer;

public interface Bag<E> extends Iterable<E> {
    public int add(E element, int count);
    public int count(Object element);
    public void forEach(Consumer<? super E> function);
    public Iterator<E> iterator();
    public AbstractCollection<E> asCollection();

    public static <T> Bag<T> createSimpleBag() {
        return new BagImpl<>(new HashMap<>());
    }

    public static <T> Bag<T> createOrderedByInsertionBag() {
        return new BagImpl<>(new LinkedHashMap<>());
    }

    public static <T> Bag<T> createOrderedByElementBag(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return new BagImpl<>(new TreeMap<>(comparator));
    }

    @SuppressWarnings("unchecked")
    public static <T> Bag<T> createOrderedByElementBagFromCollection(Collection<T> collection) {
        Objects.requireNonNull(collection);
        Bag<T> newBag = createOrderedByElementBag((Comparator<? super T>) Comparator.naturalOrder());

        for(T element : collection) {
            newBag.add(element, 1);
        }

        return newBag;
    }
}

/**
 * 1.
 * On prend un objet en paramètre parce que equals prend un objet.
 *
 * 6.
 * Collections.nCopies retourne une liste non mutable avec n copies de chaque élement.
 * La première a l'air plus rapide pour des petites structures, par contre, puisqu'on parcourt la hashMap pour créer la
 * Deque, pour les plus grandes structures, c'est peut-etre plus opti de faire la seconde méthode.
 *
 * 7.
 * On Implement l'interface Iterable, et on a plus besoin de forEach.
 *
 */
