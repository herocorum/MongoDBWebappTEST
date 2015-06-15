package test;

//import gereksiz.Todo;
//import gereksiz.TodoBean;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.model.Person;
import test.service.PersonSerfice;


@RequestMapping("todos")
@RestController
public class TodoResources {

//	@Autowired
//	private TodoBean todoBean;
	
	@Autowired
	private PersonSerfice personSerfice;
	
	private Person person =new Person();

	@RequestMapping(value = "/{content}", method = RequestMethod.GET)
	public Person createTodo(@PathVariable String content) {
		
		person.setName("Tayfuntest");
		person.setSurName("SOYAD");
//		person.setId(Long.parseLong("1"));
		personSerfice.add(person);
//		Person t =personSerfice.get(Long.parseLong("20"));
		
		return person;
	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public Todo addTodo(@RequestBody Todo todo) {
//		todo.setCreateDate(new Date());
//		todo.setState(false);
//		todo.setPriority(0);
//		todoBean.add(todo);
//		return todo;
//	}
//	
//	
//	
//	@RequestMapping(value="/a/{sid}",method = RequestMethod.GET)
//	public Todo getTodo(@PathVariable String sid ){
//		
//		return todoBean.getTodoMap().get(Integer.parseInt(sid));
//		
//	}
//	
//	@RequestMapping(value="/{sid}",method = RequestMethod.DELETE)
//		public void delTodo(@PathVariable String sid){
//			todoBean.getTodoMap().remove(Integer.parseInt(sid));
//			
//		}
//	@RequestMapping(value="/{sid}",method=RequestMethod.PUT)
//	public Todo updateTodo(@PathVariable String sid,@RequestBody Todo todo) {
//		
//		Todo todo1 = todoBean.getTodoMap().get(Integer.parseInt(sid));
//		todo1 = todo;
//		todoBean.getTodoMap().put(Integer.parseInt(sid), todo1);
//		return todo;
//	}
//	
//	
//	
//
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Person> getTodoList() {
		
		return personSerfice.getAll();
	}

}
