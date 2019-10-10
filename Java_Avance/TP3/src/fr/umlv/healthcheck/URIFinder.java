package fr.umlv.healthcheck;

import javax.swing.text.html.Option;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

@FunctionalInterface
public interface URIFinder {

    public Optional<URI> find();

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

    public static URIFinder fromArguments(String[] args) {
        Objects.requireNonNull(args);

        return () -> Optional.of(args)
                .filter(arg -> arg.length != 0)
                .flatMap(arg -> newURI(arg[0]));
    }

    public static URIFinder fromURI(String string) {
        Objects.requireNonNull(string);

        return () -> newURI(string);
    }

    public default URIFinder or(URIFinder uriFinder)
    {
        Objects.requireNonNull(uriFinder);

        return uriFinder;
    }

}

/*
La classe qui correspond à une valeur ou pas est Optional.
 */