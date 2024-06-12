package com.course.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.course.vo.Account;

@Mapper
public interface AccountMapper {
	@Insert("insert into acc(username,password)"
			+"values(#{username},#{password})")
	public void add(Account acc);
	
	@Select("select * from acc where username=#{username} and password=#{password}")
	Account queryAccount(String username,String password);

}
