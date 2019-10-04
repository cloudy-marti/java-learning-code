package fr.umlv.movies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movies
{
	static Map<String, List<String>> actorsByMovie(Path path) throws IOException
	{
		Stream<String> stream = Objects.requireNonNull(Files.lines(path));

		return stream.map(line -> line.split(";"))
				.collect(Collectors.toUnmodifiableMap(wordsInLine -> wordsInLine[0],
						wordsInLine -> Arrays.stream(wordsInLine).skip(1).collect(Collectors.toList())));
	}

	static long numberOfUniqueActors(Map<String, List<String>> actors)
	{
		/*
		return actors.values().stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toUnmodifiableSet()).size();
		 */
		return actors.values().stream()
				.flatMap(Collection::stream)
				.distinct()
				.count();
	}

	static Map<String, Long> numberOfMoviesByActor(Map<String, List<String>> actors)
	{
		/*
		return actors.values().stream()
				.flatMap(Collection::stream)
				.collect(Collectors.groupingBy(actor -> actor, Collectors.counting()));
		 */
		return actors.values().stream()
				.flatMap(Collection::stream)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	static Optional<Map.Entry<String, Long>> actorInMostMovies(Map<String, Long> map)
	{
		return map.entrySet().stream().collect(Collectors.maxBy(Comparator.comparing(Map.Entry::getValue)));
	}
}
