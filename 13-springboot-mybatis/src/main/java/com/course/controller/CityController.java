package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.CityService;
import com.course.vo.CityVo;

@RestController
public class CityController {

	@Autowired
	private CityService cityService;
	
	@GetMapping("/city")
	public List<CityVo> getAllCity() {
		return cityService.findAll();
	}
	
	@GetMapping("/city/code/{code}")
	public CityVo getCityByCode(@PathVariable String code) {
		return cityService.findByCode(code);
	}
	
	@GetMapping("/city/name/{name}")
	public List<CityVo> getCityByName(@PathVariable String name) {
		return cityService.findByName(name);
	}
	
	@PostMapping("/city")
	public void addCity(@RequestBody CityVo cityVo) {
		cityService.addCity(cityVo);
	}
	
	@PutMapping("/city")
	public void updateCity(@RequestBody CityVo cityVo) {
		cityService.updateCity(cityVo);
	}
	
	@DeleteMapping("/city/{id}")
	public void deleteCity(@PathVariable Long id) {
		cityService.deleteCity(id);
	}
}
