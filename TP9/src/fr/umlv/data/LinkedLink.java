package fr.umlv.data;

public class LinkedLink<T>
{
    private Link<T> firstLink;
    private int size;

    public LinkedLink()
    {
        this.firstLink = null;
        this.size = 0;
    }

    public void add(T value)
    {
        Link<T> newLink = new Link<>(value, this.firstLink);

        this.firstLink = newLink;
        this.size++;
    }

    public T get(int index)
    {
        if(index >= size)
        {
            throw new IllegalArgumentException();
        }

        Link<T> link = firstLink;

        for(int i = 0; i < index; ++i)
        {
            link = link.next;
        }

        return link.data;
    }

    public boolean contains(Object o)
    {
        for(Link<T> index = firstLink; index != null; index = index.next)
        {
            if(index.equals(o))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        for(Link index = firstLink; index != null; index = index.next)
        {
            str.append(index);

            if(index.next != null)
            {
                str.append("->");
            }
        }

        return str.toString();
    }
}
