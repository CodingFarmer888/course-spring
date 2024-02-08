package com.course.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.MessageEntity;
import com.course.repository.MessageRepository;
import com.course.vo.MessageVo;

@Service
public class MessageService {

	@Autowired
	private MessageRepository repository;
	
	public List<MessageEntity> getAllMessages() {
		return repository.findAllByOrderByUpdateTimeDesc();
	}
	
	public void addMessage(MessageVo messageVo) {
		MessageEntity messageEntity = new MessageEntity();
		messageEntity.setName(messageVo.getName());
		messageEntity.setSubTitle(messageVo.getSubTitle());
		messageEntity.setContent(messageVo.getContent());
		messageEntity.setSeq(1);
		messageEntity.setUpdateTime(new Date());
		repository.save(messageEntity);
				
	}
}
