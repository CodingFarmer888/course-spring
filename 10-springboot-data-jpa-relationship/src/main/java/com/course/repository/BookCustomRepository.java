package com.course.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.course.dto.BookDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class BookCustomRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
    @SuppressWarnings("unchecked")
    public List<BookDto> searchBook(String keyword) {
    	
        StringBuilder sql = new StringBuilder();
        
        sql.append(" SELECT ");
        sql.append(" B.ID ID, ");
        sql.append(" B.NAME BOOKNAME, ");
        sql.append(" B.AUTHOR AUTHOR, ");
        sql.append(" BD.PRICE PRICE, ");
        sql.append(" BD.DESCRIPT DESCRIPT, ");
        sql.append(" L.CODE LIBRARYCODE, ");
        sql.append(" L.NAME LIBRARYNAME ");
        sql.append(" FROM LIBRARY L ");
        sql.append(" JOIN LIBRARY_BOOK LB ON LB.LIBRARY_ID = L.ID ");
        sql.append(" JOIN BOOK B ON B.ID = LB.BOOK_ID ");
        sql.append(" JOIN BOOK_DETAIL BD ON B.ID = BD.BOOK_ID ");
        sql.append(" WHERE B.NAME LIKE ?1 ");
        
        // 對應到 BookDto 類別當中，在@SqlResultSetMapping設定的name
        Query query = entityManager.createNativeQuery(sql.toString(), "SearchBookMapping");
        // 參數設定
        query.setParameter(1, keyword);

        List<BookDto> resultList = query.getResultList();
        return resultList;
    }
}
