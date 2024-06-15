package com.course.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Todo;

@Repository
public interface TodoQueryRepository extends JpaRepository<Todo, Long> {
	//====================== QueryMethod =========================
	// SQL語句：select * from todo where status = ?
	List<Todo> findByStatus(Integer status);
	
	// SQL語句：select * from todo where status = ? and due_date = ?
	List<Todo> findByStatusAndDueDate(Integer status, Date dueDate);
	
	// SQL語句：select * from todo where status = ? or due_date = ?
	List<Todo> findByStatusOrDueDate(Integer status, Date dueDate);
	
	// SQL語句：select * from todo where due_date > ?
	List<Todo> findByDueDateGreaterThan(Date dueDate);
	
	// SQL語句：select * from todo where due_date >= ? and due_date <= ?
	List<Todo> findByDueDateGreaterThanEqualAndDueDateLessThanEqual(Date startDate, Date endDate);
	
	// SQL語句：select * from todo where due_date between ? and ?
	List<Todo> findByDueDateBetween(Date startDate, Date endDate);
	
	// SQL語句：select * from todo where title like ?
	List<Todo> findByTitleLike(String title);
	
	// SQL語句：select * from todo where title like '關鍵字%'
	List<Todo> findByTitleStartingWith(String title);
	
	// SQL語句：select * from todo where title like '%關鍵字'
	List<Todo> findByTitleEndingWith(String title);
	
	// SQL語句：select * from todo where title like '%關鍵字%'
	List<Todo> findByTitleContaining(String title);
	
	// SQL語句：select * from todo where id in (?, ?, ?);
	List<Todo> findByIdIn(List<Long> ids);
	
	// SQL語句：select * from todo order by due_date;
	List<Todo> findAllByOrderByDueDate();
	
	// SQL語句：select * from todo order by due_date desc;
	List<Todo> findAllByOrderByDueDateDesc();
	
	// SQL語句：select * from todo where title like ? order by due_date desc;
	List<Todo> findByTitleStartingWithOrderByDueDateDesc(String title);
	
	// SQL語句：select count(*) from todo where due_date = ?;
	Integer countByDueDate(Date dueDate);
	
	//====================== @Query =========================
	
	// SQL語句：select * from todo where status = 1 
	@Query("select t from Todo t where t.status = 1")
	List<Todo> getAllCompleteList();
	
	// SQL語句：select * from todo where status = ? and due_date <= ?
	@Query("select t from Todo t where t.status = ?1 and t.dueDate <= ?2 ")
	List<Todo> getListByCondition(Integer statue, Date dueDate);
	
	// SQL語句：select * from todo where status = ? and due_date <= ?
	@Query("select t from Todo t where t.status = :status and t.dueDate <= :dueDate ")
	List<Todo> getListByConditionNamed(@Param("status") Integer statue, @Param("dueDate") Date dueDate);
	
	// SQL語句：select * from todo where status = ? and due_date <= ?
	@Query(nativeQuery = true, value = "SELECT * FROM TODO T WHERE T.STATUS = :status AND T.DUE_DATE <= :dueDate ")
	List<Todo> getListByConditionNativeSql(@Param("status") Integer statue, @Param("dueDate") Date dueDate);
	
	@Modifying
	@Transactional
	@Query("update Todo set title = ?2 where id = ?1")
	Integer updateTodo(Long id, String title);
	
}
