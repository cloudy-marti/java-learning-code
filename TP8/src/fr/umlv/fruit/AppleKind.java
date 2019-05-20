package fr.umlv.fruit;

public enum AppleKind
{
    Golden,
    Pink_Lady,
    Granny_Smith;

    public String toString()
    {
        switch(this)
        {
            case Golden :
                return "Golden";
            case Pink_Lady :
                return "Pink Lady";
            case Granny_Smith:
                return "Granny Smith";
            default :
                return "Void Fruit";
        }
    }
}
