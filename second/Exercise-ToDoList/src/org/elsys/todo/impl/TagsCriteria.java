package org.elsys.todo.impl;

import org.elsys.todo.Task;

import java.util.Arrays;

public class TagsCriteria extends CriteriaImpl {

    private String[] tags;

    public TagsCriteria(String[] tags) {
        this.tags = tags;
    }
    @Override
    public boolean check(Task task) {

        return Arrays.asList(task.getTags()).containsAll(Arrays.asList(tags));
    }
}
