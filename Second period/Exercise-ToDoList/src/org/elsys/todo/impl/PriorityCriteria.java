package org.elsys.todo.impl;

import org.elsys.todo.Priority;
import org.elsys.todo.Task;

public class PriorityCriteria extends CriteriaImpl {

	private Priority priority;
	
	public PriorityCriteria(Priority priority) {
		super();
		this.priority = priority;
	}

	@Override
	public boolean check(Task task) {
		return task.getPriority().equals(priority);
	}

}
