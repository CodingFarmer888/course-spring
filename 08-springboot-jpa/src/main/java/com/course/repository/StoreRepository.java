package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.StoreEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

	StoreEntity findByStoreCode(String storeCode);
}
