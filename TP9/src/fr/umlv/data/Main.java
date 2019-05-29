package fr.umlv.data;

public class Main
{
    public static void main(String[] args)
    {
        Link<Integer> link = new Link<>(13, null);
        Link<Integer> link1 = new Link<>(144, null);

        LinkedLink<String> linkedLink = new LinkedLink<>();

        linkedLink.add("pamplemousse");
        linkedLink.add("doggo");
        linkedLink.add("pupperino");
        linkedLink.add("blue");
        linkedLink.add("water");

        String data = linkedLink.get(2);

        System.out.println(link + " " + link1 + "\n" + linkedLink);
        System.out.println(data.length());
        System.out.println(linkedLink.contains(new Link<>(data, null)));
    }
}

/**
 * Exercice 1 - Les listes chainées
 *
 * 1.1
 * La visibilité est rien du tout (elle est accessible dans le package courant)
 *
 * 1.2
 * Après déplacer le main dans Link.java, la commande pour compiler est :
 * >> javac -D classes src/fr/umlv/data/Link.java
 * >> java classes/fr/umlv/data/Link
 *
 * Exercice 2 - Liste chainée (suite)
 *
 * 2.4
 * On doit caster car il s'agit d'une liste d'objets et on doit dire au compilateur de quelle classe
 * il s'agit pour pouvoir utiliser les méthodes de la classe de l'objet récupéré.
 *
 * En tant que programmeur Java, ceci est un problème car, meme si à la compilation il n'y a pas d'erreurs,
 * en runtime on peut recevoir une exception si l'objet casté n'est pas une instance de la classe.
 *
 * Exercice 3 - Générification de LinkedLink
 *
 * 3.1
 * L'intéret d'utiliser un type paramétré est d'imposer des contraintes sur les types d'éléments
 * d'une structure
 * Ceci permet d'utiliser des fonctions equal, sort, etc ... Des fonctions qui nécessitent de pouvoir
 * comparer les éléments entre eux. Pour cela il faut donc qu'ils soient de meme type.
 *
 * 3.4
 * Parce qu'on ne peut pas modifier Contains, car il s'agit d'une redéfinition.
 */
