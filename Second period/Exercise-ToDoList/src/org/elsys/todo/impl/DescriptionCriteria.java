package org.elsys.todo.impl;

import org.elsys.todo.Task;

public class DescriptionCriteria extends CriteriaImpl {

	private String description;
	private boolean exact;
	
	public DescriptionCriteria(String description, boolean exact) {
		super();
		this.description = description;
		this.exact = exact;
	}

	@Override
	public boolean check(Task task) {
		if(exact == true) {
			return task.getDescription().equals(description);
		}
		return description.contains(task.getDescription());
	}


}
