package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.City;
import com.course.repository.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository cityRepository;

	public List<City> getAllCity() {
		return cityRepository.findAll();
	}
}
