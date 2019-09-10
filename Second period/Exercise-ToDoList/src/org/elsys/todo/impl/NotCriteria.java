package org.elsys.todo.impl;

import org.elsys.todo.Criteria;
import org.elsys.todo.Task;

public class NotCriteria extends CriteriaImpl{

private Criteria criteria1;
	
	
	public NotCriteria(Criteria criteria1) {
		super();
		this.criteria1 = criteria1;
	}


	@Override
	public boolean check(Task task) {
		return !criteria1.check(task);
	}
}
