package org.elsys.todo.impl;

import org.elsys.todo.Criteria;
import org.elsys.todo.Task;

public class OrCriteria extends CriteriaImpl{

	private Criteria criteria1;
	private Criteria criteria2;
	
	public OrCriteria(Criteria criteria1, Criteria criteria2) {
		super();
		this.criteria1 = criteria1;
		this.criteria2 = criteria2;
	}

	@Override
	public boolean check(Task task) {
		return criteria1.check(task) || criteria2.check(task);
	}

}
