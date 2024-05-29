package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.course.model.TodoItem;
import com.course.model.TodoVo;
import com.course.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/")
	public ModelAndView home() {

		List<TodoVo> voList = todoService.getAllTodoList();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("todoList", voList);
		return mv;
	}

	@GetMapping("/toAddPage")
	public String toAddPage(@ModelAttribute("todo") TodoItem todoItem) {
		return "addTodo";
	}

	/**
	 * 新增代辦事項
	 * @param todoVo
	 * @return
	 */
	@PostMapping("/todo")
	public String add(TodoVo todoVo) {
		System.out.println(todoVo);
		todoService.addTodo(todoVo);
		// 新增完畢後，轉導至首頁，避免refresh重送新增
		return "redirect:/";
	}
	
	@GetMapping("/toEditPage/{id}")
	public ModelAndView toEditPage(@PathVariable Integer id) {
		TodoVo vo = todoService.getTodoById(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editTodo");
		mv.addObject("todo", vo);
		return mv;
	}
	
}
