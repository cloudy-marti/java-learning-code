import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.LongSupplier;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("lambda");

        System.out.println(count(list, "hello"));  // 2
        System.out.println(countWithStream(list, "hello")); // 2
        System.out.println(count32Bits(list, "hello")); // 2

        System.out.println(upperCase(list));
        System.out.println(upperCaseWithStream(list));
        System.out.println(upperCaseWithStreamWithoutLambda(list));
        System.out.println(upperCaseWithStreamWithoutLambdaWithCollector(list));

        List<String> list2 =
            new Random(System.nanoTime())
            .ints(1_000_000, 0, 100)
            .mapToObj(Integer::toString)
            .collect(Collectors.toList());

        //System.out.println(list2);
        printAndTime(() -> count(list2, "33"));
        printAndTime(() -> countWithStream(list2, "33"));
        printAndTime(() -> count32Bits(list2, "33"));    }

    private static long count(List<String> list, String str)
    {
        long counter = 0;

        for(String word : list)
        {
            if(word.equals(str))
            {
                counter++;
            }
        }

        return counter;
    }

    private static long countWithStream(List<String> list, String str)
    {
        return list.stream()
                .filter(word -> word.equals(str))
                .count();
    }

    private static int count32Bits(List<String> list, String str)
    {
        return list.stream()
                .filter(word -> word.equals(str))
                .mapToInt(word -> 1)
                .reduce((x, y) -> x + y)
                .getAsInt();
    }

    private static List<String> upperCase(List<String> list)
    {
        ArrayList<String> upperCases = new ArrayList<>();

        for (String word : list) {
            upperCases.add(word.toUpperCase());
        }

        return upperCases;
    }

    private static List<String> upperCaseWithStream(List<String> list)
    {
        ArrayList<String> upperCases = new ArrayList<>();

        list.stream()
                .map(word -> word.toUpperCase())
                .forEach(word -> upperCases.add(word));

        return upperCases;
    }

    private static List<String> upperCaseWithStreamWithoutLambda(List<String> list)
    {
        ArrayList<String> upperCases = new ArrayList<>();

        list.stream()
                .map(String::toUpperCase)
                .forEach(word -> upperCases.add(word));

        return upperCases;
    }

    private static List<String> upperCaseWithStreamWithoutLambdaWithCollector(List<String> list)
    {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private static void printAndTime(LongSupplier lambda)
    {
        long start = System.nanoTime();
        long result = lambda.getAsLong();
        long end = System.nanoTime();

        System.out.println("result = " + result);
        System.out.println("elapsed time = " + (end - start));
    }
}


/**
 * Exercice 1 - Le compte est bon
 *
 * 1.2
 * Pour obtenir un Stream à partir d'un objet List on a juste à faire list.stream()
 * Pour filtrer on a filter() qui prend en paramètre un prédicat, un booléen dans notre cas.
 * Pour compter le nombre d'éléments qu'on a filtré on utilise la méthode count().
 *
 * Exercice 2 - En majuscule
 *
 * 2.2
 * On utilise la méthode Stream.map avec une lambda à l'intérieur pour transformer les éléments de la liste
 * comme on le souhaite.
 *
 * Exercice 3 - Comptons sur une réduction
 *
 * 3.1
 * On utilise la méthode mapToInt car map renvoie une stream d'Objets, et nous voulons des Int.
 * mapToInt renvoie une stream d'entiers, ce qui est exactement ce qu'on veut.
 *
 * Exercice 4 - Evaluation de vitesse
 *
 * 4.1
 * La variable list2 renvoie une liste contenant 1 000 000 objets de type String
 * Ces objets étaient à la base des entiers randomisés entre 0 et 100
 *
 * 4.3
 * On doit utiliser l'interface fonctionnelle LongSupplier, qui va nous fournir un long
 *
 * 4.4
 * count et count2 prennent quasiment le meme temps pour se réaliser.
 * Elles prennent plus de temps que count3 car la première parcourre la liste, et la deuxième travaille
 * sur des objets qu'elle va devoir convertir un à un en int pour les compter
 * count3 on transforme tout en int et on fait de simples opérations sur int
 */