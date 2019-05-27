package fr.umlv.data;

import java.util.Objects;

class Link<T>
{
    final T data;
    final Link<T> next;

    public Link(T data, Link<T> next)
    {
        this.data = data;
        this.next = next;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link<?> link = (Link<?>) o;
        return Objects.equals(data, link.data);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(data);
    }

    @Override
    public String toString()
    {
        StringBuilder linkStr = new StringBuilder();

        linkStr.append("[");
        linkStr.append(data);
        linkStr.append("|");

        linkStr.append((next == null)?"\\":" ");

        linkStr.append("]");

        return linkStr.toString();
    }
}