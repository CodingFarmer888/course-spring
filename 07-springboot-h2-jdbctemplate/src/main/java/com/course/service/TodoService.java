package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.TodoDao;
import com.course.model.TodoItem;
import com.course.model.TodoVo;

@Service
public class TodoService {

	@Autowired
	private TodoDao todoDao;
	
	/**
	 * 取得所有代辦事項
	 * @return
	 */
	public List<TodoVo> getAllTodoList() {
		List<TodoItem> itemList = todoDao.findAll();

		// 轉換物件
		List<TodoVo> voList = itemList.stream().map(item -> {
			return convertToVo(item);
		}).collect(Collectors.toList());
		
		return voList;
	}
	
	/**
	 * 新增代辦事項
	 * @param todoVo
	 */
	public void addTodo(TodoVo todoVo) {
		// 將承接前端物件轉換為操作 Dao 物件
		TodoItem item = new TodoItem();
		item.setTitle(todoVo.getTitle());
		item.setDueDate(parseDate(todoVo.getDueDate()));
		// 新增代辦事項，狀態固定為0(未完成)
		item.setStatus(0);
		todoDao.insert(item);
	}
	
	/**
	 * 透由ID 查詢
	 * @param id
	 * @return
	 */
	public TodoVo getTodoById(Integer id) {
		TodoItem item = todoDao.findById(id);
		return convertToVo(item);
	}
	
	/**
	 * 刪除代辦事項
	 * @param id
	 * @return
	 */
	public Integer deleteById(Integer id) {
		return todoDao.delete(id);
	}
	
	/**
	 * 更新代辦事項
	 * @param todoVo
	 * @return
	 */
	public Integer updateTodo(TodoVo todoVo) {
		TodoItem item = new TodoItem();
		item.setId(todoVo.getId());
		item.setTitle(todoVo.getTitle());
		item.setDueDate(parseDate(todoVo.getDueDate()));
		item.setStatus(todoVo.getStatus());
		return todoDao.update(item);
	}
	
	
	/**
	 * 轉換日期
	 * @param dueDateStr
	 * @return
	 */
	private Date parseDate(String dueDateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(dueDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	/**
	 * 日期轉換字串
	 * @param date
	 * @return
	 */
	private String parseDateToString(Date date) {
	     // 定義日期格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // 將 Date 物件轉換為 String
        return formatter.format(date);
	}
	
	/**
	 * 轉換物件
	 * @param item
	 * @return
	 */
	private TodoVo convertToVo(TodoItem item) {
		TodoVo vo = new TodoVo();
		vo.setId(item.getId());
		vo.setTitle(item.getTitle());
		vo.setDueDate(parseDateToString(item.getDueDate()));
		vo.setStatus(item.getStatus());
		vo.setStatusDisp(item.getStatus() == 0 ? "未完成" : "已完成");
		return vo;
	}
}
