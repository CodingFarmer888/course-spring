package com.course.config;

import org.springframework.batch.item.ItemProcessor;

import com.course.entity.Person;

public class CsvItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person item) throws Exception {
		
		String gender = item.getGender();
		if (!("男".equals(gender) || "女".equals(gender))) {
			return null;
		}
		return item;
	}

}
