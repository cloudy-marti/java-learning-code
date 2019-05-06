package fr.umlv.geom.main;

import fr.umlv.geom.Circle;
import fr.umlv.geom.Point;
import fr.umlv.geom.Ring;

public class Main
{
    public static void main(String[] args)
    {
        /*Point p = new Point(1, 2);
        Circle c = new Circle(p, 1);

        Circle c2 = new Circle(p, 2);
        c2.translate(1, 1);

        System.out.println(c + "\n" + c2 + "\np = " + p);


        Point point = new Point(1, 2);
        Circle circle = new Circle(point, 1);
        circle.getCenter().translate(1,1);
        System.out.println(circle);*/

        Point p=new Point(1,2);
        Circle c=new Circle(p,2);
        System.out.println(c);
        Ring r = new Ring(p, 2, 1);
        System.out.println(r);
    }
}

/***
 * Exercice 1.
 *
 * 1.1
 * Le code ne compile pas car les champs x et y étaient final
 * et on essayait de les changer avec la méthode translate, ce qui est interdit
 *
 * Soit on les laisse final et translate return un nouveau point avec la nouvelle position
 * Soit on enlève les final
 *
 * 1.2
 * On doit préciser de base qu'ils sont private et final.
 *
 * 1.10
 * ... veut dire qu'on peut passer en argument autand d'objets de type Circle qu'on veut
 *
 * Exercice 2.
 *
 * 2.1
 * Il est judicieux de faire un héritage lorsqu'il y a deux classes qui ont des méthodes en commun.
 * La classe mère doit etre une classe qui "englobe" les classes filles.
 * Par exemple, on a une classe chien, une classe chat, une classe hamster ... qui héritent de la classe mammifère.
 * On pourra faire de la redéfinition.
 */