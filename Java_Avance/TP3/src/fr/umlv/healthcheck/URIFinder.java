package fr.umlv.healthcheck;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

@FunctionalInterface
public interface URIFinder {
    public static URIFinder fromArguments(String[] args) {
        Objects.requireNonNull(args);

        return () -> Optional
                .of(args)
                .filter(arg -> arg.length != 0)
                .flatMap(arg -> URI.create(arg[0]));
    }

    private static Optional<URI> newURI (String string)
    {
        try
        {
            return Optional.of(new URI(string));
        }
        catch (URISyntaxException e)
        {
            return Optional.empty();
        }
    }

    public static URIFinder fromURI(String string) {
        Objects.requireNonNull(string);

        return () -> newURI(string);
    }

    public Optional<URI> find();
}

/*
La classe qui correspond à une valeur ou pas est Optional.
 */