package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.MessageEntity;
import com.course.service.MessageService;
import com.course.vo.MessageVo;

@RestController
public class MessageController {

	@Autowired
	private MessageService service;
	
	@PostMapping("/message")
	public void addMessage(@RequestBody MessageVo messageVo) {
		service.addMessage(messageVo);
	}
	
	@GetMapping("/messages")
	public ResponseEntity<List<MessageEntity>> getMessages() {
		List<MessageEntity> messageList = service.getAllMessages();
		return ResponseEntity.ok(messageList);
	}
}
