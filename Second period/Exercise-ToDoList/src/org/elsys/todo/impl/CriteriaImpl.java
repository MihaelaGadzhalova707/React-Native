package org.elsys.todo.impl;

import org.elsys.todo.Criteria;
import org.elsys.todo.Task;

public abstract class CriteriaImpl implements Criteria {

	@Override
	public Criteria and(Criteria other) {
		return new AndCriteria(this,other);
	}

	@Override
	public Criteria or(Criteria other) {
		return new OrCriteria(this,other);
	}

	@Override
	public Criteria xor(Criteria other) {
		return new XorCriteria(this,other);
	}

	@Override
	public Criteria not() {
		return new NotCriteria(this);
	}
	
	public abstract boolean check(Task task);

}
