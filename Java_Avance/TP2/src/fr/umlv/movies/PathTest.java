package fr.umlv.movies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathTest
{
	public static void main(String[] args) throws IOException
	{
		Path moviesPath = Path.of("movies.txt");

		/*Stream<String> stringStream = Objects.requireNonNull(Files.lines(moviesPath));
		stringStream.forEach(System.out::println);
		stringStream.close();*/

		/*
		Movies.actorsByMovie(moviesPath).values().stream()
				.flatMap(Collection::stream)
				.limit(50).forEach(System.out::println);

		 */

		/*
		System.out.println(Movies.actorsByMovie(moviesPath).values().stream()
				.flatMap(Collection::stream)
				.count());
		 */

		System.out.println(Movies.actorsByMovie(moviesPath).values().stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toUnmodifiableSet()).size());
	}

	/*
	public static void main(String[] args) throws IOException
	{
		Path moviesPath = Path.of("movies.txt");

		try(Stream<String> stringStream = Objects.requireNonNull(Files.lines(moviesPath))
		{
			stringStream.forEach(str -> System.out.println(str));
		}
	}
	*/

	/*
	public static void main(String[] args)
	{
		Path moviesPath = Path.of("movies.txt");
		Stream<String> stringStream;

		try
		{
			stringStream = Objects.requireNonNull(Files.lines(moviesPath));
		} catch (IOException ioE)
		{
			System.out.println("IOException : " + ioE);
			throw new IllegalStateException("File cannot be opened");
			// throw new UncheckedIOException(ioE);
		}

		try
		{
			stringStream.forEach((str) -> System.out.println(str));
		} finally
		{
			stringStream.close();
			System.out.println("finally !");
		}
	}*/
}

/***
 * Exercice 1
 * 1 .
 * http s://docs.oracle.com/javase/tutorial/essential/io/legacy.html
 *
 *
 */
