package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.mapper.CityMapper;
import com.course.vo.CityVo;

@Service
public class CityService {

	@Autowired
	private CityMapper cityMapper;
	
	public List<CityVo> findAll() {
		return cityMapper.findAll();
	}
	
	public CityVo findByCode(String code) {
		return cityMapper.findByCode(code);
	}
	
	public List<CityVo> findByName(String name) {
		String searchName = "%" + name + "%";
		return cityMapper.findByNameLike(searchName);
	}
	
	public void addCity(CityVo cityVo) {
		cityMapper.insertCity(cityVo);
	}
	
	public void updateCity(CityVo cityVo) {
		cityMapper.updateCity(cityVo);
	}
	
	public void deleteCity(Long id) {
		cityMapper.deleteByid(id);
	}
}
