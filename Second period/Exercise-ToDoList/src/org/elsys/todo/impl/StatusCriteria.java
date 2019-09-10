package org.elsys.todo.impl;

import org.elsys.todo.Status;
import org.elsys.todo.Task;

public class StatusCriteria extends CriteriaImpl{

	private Status status;
	
	
	public StatusCriteria(Status status) {
		super();
		this.status = status;
	}


	@Override
	public boolean check(Task task) {
		return task.getStatus().equals(status);
	}

}
