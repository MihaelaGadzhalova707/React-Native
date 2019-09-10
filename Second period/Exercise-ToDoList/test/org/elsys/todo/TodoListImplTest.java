package org.elsys.todo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TodoListImplTest {

	private TodoList todoList = TodoList.parse(
			"TODO    | Do OOP homework              | Low    | school, programming\r\n" + 
			"TODO    | Get 8 hours of sleep.        | Low    | health\r\n" + 
			"DOING   | Party hard.                  | Normal | social\r\n" + 
			"DONE    | Netflix and chill.           | Normal | tv shows\r\n" + 
			"TODO    | Find missing socks.          | Low    | meh\r\n" + 
			"");
	
	@Test
	public void testMatchingPercentage() {
		assertEquals(Double.valueOf(60.00), todoList.matchingPercentage(Criteria.priority(Priority.LOW)));
		assertEquals(Double.valueOf(00.00), todoList.matchingPercentage(Criteria.tags(new String[] {"health"}).and(Criteria.status(Status.DOING))));
		assertEquals(Double.valueOf(40.00), todoList.matchingPercentage(Criteria.tags(new String[] {"school", "programming"}).or(Criteria.tags(new String[] {"meh"}))));
	}
	
	@Test
	public void filterByStatus() {
		assertEquals(1, todoList.filter(Criteria.status(Status.DOING)).getTasks().size());
		assertEquals(1, todoList.filter(Criteria.status(Status.DONE)).getTasks().size());
		assertEquals(3, todoList.filter(Criteria.status(Status.TODO)).getTasks().size());
	}
	
	@Test
	public void filterByPriority() {
		assertEquals(3, todoList.filter(Criteria.priority(Priority.LOW)).getTasks().size());
		assertEquals(2, todoList.filter(Criteria.priority(Priority.NORMAL)).getTasks().size());
		assertEquals(0, todoList.filter(Criteria.priority(Priority.HIGH)).getTasks().size());
	}
	
	@Test
	public void filterByTags() {
		assertEquals(0, todoList.filter(Criteria.tags(new String[] {"school","fun"})).getTasks().size());
		assertEquals(1, todoList.filter(Criteria.tags(new String[] {"health"})).getTasks().size());
		assertEquals(1, todoList.filter(Criteria.tags(new String[] {"school","programming"})).getTasks().size());
	}
	
	@Test
	public void filterByAndCriteria() {
		assertEquals(0, todoList.filter(Criteria.priority(Priority.LOW).and(Criteria.status(Status.DONE))).getTasks().size());
		assertEquals(3, todoList.filter(Criteria.priority(Priority.LOW).and(Criteria.status(Status.TODO))).getTasks().size());
		assertEquals(1, todoList.filter(Criteria.status(Status.DONE).and(Criteria.priority(Priority.NORMAL))).getTasks().size());
	}
	

	@Test
	public void filterByOrCriteria() {
		assertEquals(4, todoList.filter(Criteria.status(Status.DOING).or(Criteria.status(Status.TODO))).getTasks().size());
		assertEquals(2, todoList.filter(Criteria.status(Status.DOING).or(Criteria.tags(new String[] {"health"}))).getTasks().size());
		assertEquals(3, todoList.filter(Criteria.priority(Priority.LOW).or(Criteria.tags(new String[] {"health"}))).getTasks().size());
	}
	
	@Test
	public void filterByXorCriteria() {
		assertEquals(4, todoList.filter(Criteria.status(Status.DOING).xor(Criteria.status(Status.TODO))).getTasks().size());
		assertEquals(2, todoList.filter(Criteria.status(Status.DOING).xor(Criteria.tags(new String[] {"health"}))).getTasks().size());
		assertEquals(2, todoList.filter(Criteria.priority(Priority.LOW).xor(Criteria.tags(new String[] {"health"}))).getTasks().size());
	}
	
	@Test 
	public void testJoin() {
		assertEquals(3,todoList.filter(Criteria.priority(Priority.LOW)).join(todoList.filter(Criteria.status(Status.TODO))).getTasks().size());
		assertEquals(1, todoList
							.filter(Criteria.tags(new String[] { "school" }))
							.join(todoList
									.filter(Criteria.priority(Priority.HIGH)))
							.getTasks().size());
			
		assertEquals(4, todoList.filter(Criteria.priority(Priority.LOW))
					.join(todoList.filter(Criteria.status(Status.DOING))).getTasks().size());	

	}
	
	@Test
	public void testCount() {
		assertEquals(1, todoList.count(Criteria.status(Status.DOING)));
		assertEquals(3, todoList.count(Criteria.status(Status.TODO)));
		assertEquals(1, todoList.count(Criteria.status(Status.DONE)));
	}
	
	@Test
	public void filterByDescription() {
		assertEquals(0, todoList.filter(Criteria.description("OOP", false)).getTasks().size());
		assertEquals(0, todoList.filter(Criteria.description("OOP", true)).getTasks().size());
	}
	
}
