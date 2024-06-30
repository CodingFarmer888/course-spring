package com.course.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.course.dto.UserRptDto;
import com.course.entity.User;

public interface UserJpaDao extends JpaRepository<User, Long> {
	
	@Query("select new com.course.dto.UserRptDto(u.id, u.name, o.id) from User u join Order o on u.id = o.userId where u.id = ?1")
	public List<UserRptDto> findUserOrders(Long userId);
	
	@Query("select new com.course.dto.UserRptDto(u.id, u.name, o.id, t.productName, t.productPrice) from User u join Order o on u.id = o.userId join OrderItem t on t.orderId = o.id where u.id = ?1")
	public List<UserRptDto> findUserOrdersProducts(Long userId);

}
