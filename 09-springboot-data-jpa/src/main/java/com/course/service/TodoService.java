package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.course.entity.Todo;
import com.course.model.TodoVo;
import com.course.repository.TodoQueryRepository;
import com.course.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private TodoQueryRepository todoQueryRepository;
	
	/**
	 * 取得所有待辦事項
	 * @return
	 */
	public List<TodoVo> getAllTodoList() {
		List<Todo> todoList = todoRepository.findAll();
		return convertVoList(todoList);
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
	
	/** ========== QueryMehtod ========== */
	
	/**
	 * 依照狀態查詢
	 * @param status
	 * @return
	 */
	public List<TodoVo> findByStatus(Integer status) {
		List<Todo> todoList = todoQueryRepository.findByStatus(status);
		return todoList.stream().map(entity -> {
			return convertToVo(entity);
		}).collect(Collectors.toList());
	}
	
	/**
	 * 依照狀態與到期日查詢
	 * @param status
	 * @param dueDate
	 * @return
	 */
	public List<TodoVo> findByStatusAndDueDate(Integer status, String dueDate) {
		List<Todo> todoList = todoQueryRepository.findByStatusOrDueDate(status, parseDate(dueDate));
		return convertVoList(todoList);
	}
	
	/**
	 * 依照到期日查詢
	 * @param dueDate
	 * @return
	 */
	public List<TodoVo> findByDueDateGreaterThan(String dueDate) {
		List<Todo> todoList = todoQueryRepository.findByDueDateGreaterThan(parseDate(dueDate));
		return convertVoList(todoList);
	}
	
	/**
	 * 依照到期日區間查詢
	 * @param dueDate
	 * @return
	 */
	public List<TodoVo> findByDateRange(String startDate, String endDate) {
		List<Todo> todoList = todoQueryRepository.findByDueDateGreaterThanEqualAndDueDateLessThanEqual(parseDate(startDate), parseDate(endDate));
		return convertVoList(todoList);
	}
	
	/**
	 * 依照到期日區間查詢
	 * @param dueDate
	 * @return
	 */
	public List<TodoVo> findByDateBetween(String startDate, String endDate) {
		List<Todo> todoList = todoQueryRepository.findByDueDateBetween(parseDate(startDate), parseDate(endDate));
		return convertVoList(todoList);
	}
	
	/**
	 * 標題關鍵字查詢
	 * @param keyword
	 * @return
	 */
	public List<TodoVo> findByTitleKeyword(String keyword) {
		String titleKeyword = "%" + keyword + "%";
		List<Todo> todoList = todoQueryRepository.findByTitleLike(titleKeyword);
		
		// findByTitleStartingWith findByTitleEndingWith findByTitleContaining 不用加%
		// List<Todo> todoList = todoQueryMethodRepository.findByTitleStartingWith(keyword);
		return convertVoList(todoList);
	}
	
	/**
	 * 依照id的列表進行查詢
	 * @param ids
	 * @return
	 */
	public List<TodoVo> findByIdList(List<Long> ids) {
		List<Todo> todoList = todoQueryRepository.findByIdIn(ids);
		return convertVoList(todoList);
	}
	
	/**
	 * 查詢全部並針對到期日排序
	 * @return
	 */
	public List<TodoVo> findAllOrderByDueDate() {
		List<Todo> todoList = todoQueryRepository.findAllByOrderByDueDate();
		return convertVoList(todoList);
	}
	
	/**
	 * 使用title做關鍵字查詢，並針對到期日做降冪排序
	 * @param keyword
	 * @return
	 */
	public List<TodoVo> findByTitleStartingWithOrderByDueDate(String keyword) {
		List<Todo> todoList = todoQueryRepository.findByTitleStartingWithOrderByDueDateDesc(keyword);
		return convertVoList(todoList);
	}
	
	/**
	 * 透過日期計數
	 * @param dueDate
	 * @return
	 */
	public Integer countByDueDate(String dueDate) {
		return todoQueryRepository.countByDueDate(parseDate(dueDate));
	}
	
	/** ========== @Query ========== */
	
	/**
	 * 使用 @Query 進行查詢
	 * @return
	 */
	public List<TodoVo> findAllCompleteList() {
		List<Todo> todoList = todoQueryRepository.getAllCompleteList();
		return convertVoList(todoList);
	}
	
	/**
	 * 使用 @Query 進行查詢
	 * 分別使用 PositionParam NamedParam NativeSQL
	 * @param dueDate
	 * @return
	 */
	public List<TodoVo> findUnCompleteList(String dueDate) {
		// PositionParam
		List<Todo> todoList = todoQueryRepository.getListByCondition(0, parseDate(dueDate));
		// NamedParam
		// List<Todo> todoList = todoQueryRepository.getListByConditionNamed(0, parseDate(dueDate));
		// NativeSQL
		// List<Todo> todoList = todoQueryRepository.getListByConditionNativeSql(0, parseDate(dueDate));
		return convertVoList(todoList);
	}
	
	/**
	 * 使用@Query 進行 更新
	 * @param id
	 * @param title
	 * @return
	 */
	public Integer updateTodoTitle(Long id, String title) {
		return todoQueryRepository.updateTodo(id, title);
	}
	
	/** ========== 排序 與 分頁 ========== */
	
	public List<TodoVo> findAllAndSort() {
		// 不指定排序方式預設為升冪排序
		// Sort sort = Sort.by("dueDate", "title");
		// 個別指定排序方式
		Sort sort = Sort.by(Sort.Order.asc("dueDate"), Sort.Order.desc("title"));
		List<Todo> todoList = todoRepository.findAll(sort);
		return convertVoList(todoList);
	}
	
	
	/** ========== 工具 ========== */
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
	
	/**
	 * Entity 轉換成 Vo 物件
	 * @param entity
	 * @return
	 */
	private TodoVo convertToVo(Todo entity) {
		TodoVo vo = new TodoVo();
		vo.setId(entity.getId());
		vo.setTitle(entity.getTitle());
		vo.setDueDate(parseDateToString(entity.getDueDate()));
		vo.setStatus(entity.getStatus());
		vo.setStatusDisp(entity.getStatus() == 0 ? "未完成" : "已完成");
		return vo;
	}
	
	/**
	 * 字串轉換日期
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
	 * 列表轉換
	 * @param todoList
	 * @return
	 */
	private List<TodoVo> convertVoList(List<Todo> todoList) {
		return todoList.stream().map(entity -> {
			return convertToVo(entity);
		}).collect(Collectors.toList());
	}

}
