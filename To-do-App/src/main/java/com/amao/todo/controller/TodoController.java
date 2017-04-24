package com.amao.todo.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.amao.todo.pojo.Todo;
import com.amao.todo.service.TodoPersistenceService;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("name")
public class TodoController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	TodoPersistenceService service;
	
	/*@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}*/
	
	//list-GET
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)//visit /list-todos
	public String listTodo(ModelMap model){
		String user = (String) model.get("name");
		model.addAttribute("todos", service.retrieveTodos(user));//list the todos of the user
		return "list-todos";
	}
	
	//add-GET
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)// visit add-todo, show add page
	public String showTodoPage(ModelMap model){
		Todo todo = new Todo();
		//这个信息可以显示在form中
		todo.setDescript("Default");
		//todo.setUser("amao");
		//传入modelAttribute的field丢失了！
		model.addAttribute("todo", todo);//for modelAttribute
		
		return "add-todo";//give add-toso.jsp
	}
	
	
	//add-POST
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)//submit from add-todo.jsp, visit/add-todo with post
	public String addTodoPage(ModelMap model,@Valid Todo todo,BindingResult result){
		if(result.hasErrors()){//valid Todo
			return "add-todo";
		}
		//add Todo.desc from textbox
		todo.setUser((String)model.get("name"));
		todo.setTargetDate(new Date());
		todo.setDone(0);
		service.addProduct(todo);
		//service.addTodo((String)model.get("name"), todo.getDesc(), new Date(), false);
		
		model.clear();//remove name attribute
		
		//visit /list-todos url
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)// visit update-todo, show add page
	public String updateTodoPage(ModelMap model, @RequestParam int id){
		//Todo todo = service.retrieveTodo(id);
		//model.addAttribute("todo", todo);//for modelAttribute
		
		return "update-todo";//give add-toso.jsp
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)//
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult res){
		if(res.hasErrors()){//valid Todo
			return "update-todo";
		}
		//service.deleteTodo(todo.getId());
		//service.addTodo((String)model.get("name"), todo.getDesc(), todo.getTargetDate(), todo.isDone());
		model.clear();
		return "redirect:list-todos";
	}
	
	//delete-GET,
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id){
		//service.deleteTodo(id);
		model.clear();
		return "redirect:list-todos";
	}
}
