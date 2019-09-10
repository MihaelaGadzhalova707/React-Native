package org.elsys.todo.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.elsys.todo.Criteria;
import org.elsys.todo.Priority;
import org.elsys.todo.Status;
import org.elsys.todo.Task;
import org.elsys.todo.TodoList;
import org.elsys.todo.impl.TodoListImpl;

public class TodoListImpl implements TodoList {

	private List<Task> tasks;

	/**
	 * TODO    | Do OOP homework              | Low    | school, programming
	 * TODO    | Get 8 hours of sleep.        | Low    | health
	 * DOING   | Party hard.                  | Normal | social
	 * DONE    | Netflix and chill.           | Normal | tv shows
	 * TODO    | Find missing socks.          | Low    | meh

	 * @param input
	 */
	public TodoListImpl(String input) {
		tasks = Arrays.stream(input.split("\n")).map(line -> {
			String[] splitted = Arrays.stream(line.split("\\|"))
				.map(String::trim)
				.toArray(size -> new String[size]);
			return new TaskImpl(
					Status.valueOf(splitted[0].toUpperCase()),
					splitted[1],
					Priority.valueOf(splitted[2].toUpperCase()),
					splitted[3].split(", "));
		}).collect(Collectors.toList());
	}

	public TodoListImpl(List<Task> list) {
		tasks = list;
	}

	@Override
	public Boolean isCompleted() {
		for(Task task : tasks) {
			if(!(task.getStatus().equals(Status.DONE))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Double completedPercentage() {
		int count = 0;
		for(Task task : tasks) {
			if(task.getStatus().equals(Status.DONE)) {
				count++;
			}
		}
		double intoPercentage = (((count * 100.0) / (tasks.size()) * 100.0) / 100.0);
		return (double) Math.round(intoPercentage);
	}

	@Override
	public Double statusPercentage(Status status) {
		TodoList filtered = filter(new StatusCriteria(status));
		return (double) Math.round(((filtered.getTasks().size()*100)/tasks.size()) * 100.0) / 100.0;
	}

	@Override
	public Double matchingPercentage(Criteria criteria) {
		TodoList filtered = filter(criteria);
		return (double) Math.round(((filtered.getTasks().size()*100)/tasks.size()) * 100.0) / 100.0;
	}

	@Override
	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public TodoList filter(Criteria criteria) {
		List<Task> result = tasks.stream().filter(criteria::check).collect(Collectors.toList());
        return new TodoListImpl(result);
	}

	@Override
	public int count(Criteria criteria) {
		return filter(criteria).getTasks().size();
	}

	@Override
	public void each(Consumer<Task> consumer) {
		for(Task task: tasks) {
			consumer.accept(task);
		}
	}
	
	@Override
	public TodoList join(TodoList other) {
		Set<Task> setTask = new HashSet<Task>();
		setTask.addAll(this.getTasks());
		setTask.addAll(other.getTasks());
		List<Task> task = new ArrayList<>(setTask);
		return new TodoListImpl(task);
	}

}
