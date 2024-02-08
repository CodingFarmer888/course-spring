package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
