package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.TodoVo;
import com.course.entity.Todo;
import com.course.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> getAllTodoList() {
		return todoRepository.findAll();
	}
	
	
	public Todo insertTodo(TodoVo todoVo) {
		Todo entity = convertToEntity(todoVo);
		return todoRepository.save(entity);
	}
	
	private Todo convertToEntity(TodoVo vo) {
		Todo entity = new Todo();
		entity.setTitle(vo.getTitle());
		entity.setDueDate(parseDate(vo.getDueDate()));
		entity.setStatus(vo.getStatus());
		return entity;
		
	}
	
	private Date parseDate(String dueDateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(dueDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
	}
	
}
