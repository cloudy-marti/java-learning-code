package fr.umlv.healthcheck;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Function;

@FunctionalInterface
public interface URIFinder {

    Optional<URI> find();

    private static Optional<URI> newURI(String string) {
        if (string == null) {
            return Optional.empty();
        }

        try {
            return Optional.of(new URI(string));
        } catch (URISyntaxException e) {
            return Optional.empty();
        }
    }

    static URIFinder fromArguments(String[] args) {
        Objects.requireNonNull(args);

        return () -> Optional.of(args)
                .filter(arg -> arg.length != 0)
                .flatMap(arg -> newURI(arg[0]));
    }

    static URIFinder fromURI(String string) {
        Objects.requireNonNull(string);

        return () -> newURI(string);
    }

    default URIFinder or(URIFinder uriFinder) {
        Objects.requireNonNull(uriFinder);

        /*
        // Moins élégant mais ça marche :
        if(this.find().isEmpty())
        {
            return uriFinder;
        }
        else
        {
            return this;
        }*/

        return () -> find().or(uriFinder::find);
    }

    static <T> URIFinder fromMapGetLike(T key, Function<? super T, String> get) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(get);

        String url = get.apply(key);

        return () -> newURI(url);
    }

    static URIFinder fromPropertyFile(Path path, String url) throws IOException {
        Objects.requireNonNull(path);
        Objects.requireNonNull(url);

        var properties = new Properties();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            properties.load(bufferedReader);
            return () -> newURI(properties.getProperty(url));
        } catch (FileNotFoundException e) {
            return () -> Optional.empty();
        }
    }
}