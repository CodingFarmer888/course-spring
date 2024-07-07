package com.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.course.vo.CityVo;

@Mapper
public interface CityMapper {

	@Select("SELECT * FROM city")
	List<CityVo> findAll();
	
	@Select("SELECT * FROM city WHERE code = #{code}")
	CityVo findByCode(String code);
	
	@Select("SELECT * FROM city WHERE name LIKE #{name}")
	List<CityVo> findByNameLike(String name);
	
	@Insert("INSERT INTO city (code, name) VALUES (#{code}, #{name})")
	void insertCity(CityVo cityVo);
	
	@Update("UPDATE city SET code = #{code}, name = #{name} WHERE id = #{id}")
	void updateCity(CityVo cityVo);
	
	@Delete("DELETE FROM city WHERE id = #{id}")
	void deleteByid(Long id);
	
}
