package com.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.course.vo.BookVo;
import com.course.vo.StudentVo;

@Mapper
public interface BookMapper {

	@Select("SELECT * FROM book")
	List<BookVo> findAll();
	
	@Select("SELECT * FROM book WHERE id = #{id} ")
	BookVo findById(Long id);
	
	@Insert("INSERT INTO book (name, author) VALUES (#{name}, #{author})")
	void insert(BookVo book);
	
	@Update("UPDATE book SET name = #{name}, author = #{author} WHERE id = #{id}")
	void update(BookVo book);
	
	@Delete("DELETE FROM book WHERE id = #{id}")
	void delete(Long id);
	
	@Select("SELECT b.id id, b.name name, b.author author, s.name owner FROM book b JOIN student s ON b.student_id = s.id WHERE s.id = #{studentId}")
	List<BookVo> findStudentBooks(Long studentId);
}
