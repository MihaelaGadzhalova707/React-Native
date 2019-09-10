package org.elsys.streams.practice;

import java.util.List;

public class Sum {

    public static int calculate(List<Integer> people) {
        return people.stream()
        		.reduce(0, (p1, p2) -> p1 + p2);
    }

}
