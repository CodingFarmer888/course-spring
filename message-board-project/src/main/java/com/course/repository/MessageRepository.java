package com.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
	
	public List<MessageEntity> findAllByOrderByUpdateTimeDesc();

}
