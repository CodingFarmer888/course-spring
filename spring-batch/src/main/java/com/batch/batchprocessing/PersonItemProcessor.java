package com.batch.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.batch.record.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	  
	/**
	 * 處理邏輯
	 * 將傳入物件執行需求邏輯，再傳出
	 */
	@Override
	public Person process(Person person) throws Exception {
		
		// 單純轉大寫
	    String firstName = person.firstName().toUpperCase();
	    String lastName = person.lastName().toUpperCase();

	    Person transformedPerson = new Person(firstName, lastName);

	    // 寫入log
	    log.info("Converting (" + person + ") into (" + transformedPerson + ")");

	    return transformedPerson;
	}
}
