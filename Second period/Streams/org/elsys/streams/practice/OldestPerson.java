package org.elsys.streams.practice;

import java.util.Comparator;
import java.util.List;

public class OldestPerson {

    public static Person getOldestPerson(List<Person> people) {
        return people.stream()
        		.max(Comparator.comparing(ft -> ft.getAge()))
        		.get();
    }

}
