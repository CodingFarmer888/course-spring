package com.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.course.vo.BookVo;

// @Mapper
public interface BookMapper {

    @Select("SELECT * FROM book b JOIN book_detail bd on bd.book_id = b.id ")
    List<BookVo> findAll();

    @Insert("INSERT INTO book (name, author) VALUES (#{name}, #{author})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertBook(BookVo book);
    
    @Insert("INSERT INTO book_detail (book_id, price, descript) VALUES (#{id}, #{price}, #{descript})")
    void insertBookDetail(BookVo book);

	List<BookVo> findByCondition(BookVo vo);
	
	List<BookVo> findByChoose(BookVo vo);
	
	List<BookVo> findByWhere(BookVo vo);
	
	List<BookVo> findByNames(List<String> names);
	
	void updateByCondition(BookVo book);
}
