package org.elsys.streams.practice;

import java.util.List;
import java.util.stream.Collectors;

public class FlatCollection {

    public static List<String> transform(List<List<String>> collection) {
        return collection.stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
    }

}
