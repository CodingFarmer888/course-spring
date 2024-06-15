package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.Todo;
import com.course.model.TodoVo;
import com.course.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	/**
	 * 取得所有待辦事項
	 * @return
	 */
	public List<Todo> getAllTodoList() {
		return todoRepository.findAll();
	}
	
	/**
	 * 透過ID取得待辦事項
	 * @param id
	 * @return
	 */
	public Todo getTodoById(Long id) {
		return todoRepository.findById(id).orElse(null);
	}
	
	/**
	 * 新增或更新 待辦事項
	 * @param todoVo
	 * @return
	 */
	public Todo updateTodo(TodoVo todoVo) {
		Todo entity = convertToEntity(todoVo);
		return todoRepository.save(entity);
	}
	
	/**
	 * 透過ID刪除 待辦事項
	 * @param id
	 */
	public void deleteTodoById(Long id) {
		todoRepository.deleteById(id);
	}
	
	/**
	 * 透過實體刪除 待辦事項
	 * @param id
	 */
	public void deleteTodo(TodoVo todoVo) {
		Todo entity = convertToEntity(todoVo);
		todoRepository.delete(entity);
	}
	
	/**
	 * 整批刪除全部資料
	 */
	public void deleteAllInBatch() {
		todoRepository.deleteAllInBatch();
	}
	
	/**
	 * 刪除全部資料
	 */
	public void deleteAll() {
		todoRepository.deleteAll();
	}
	
	/**
	 * 待辦事項 是否存在
	 * @param id
	 * @return
	 */
	public boolean isTodoExist(Long id) {
		return todoRepository.existsById(id);
	}
	
	
	/**
	 * Vo 轉換成 Entity
	 * @param vo
	 * @return
	 */
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
