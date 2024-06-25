package com.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class CriteriaService {

	// @Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Book> findBooksByAuthor(String author, String keyword) {
        // 創建 CriteriaBuilder
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        
        // 創建 CriteriaQuery，宣告查詢的結果為 Book 型別
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        // 從 Book 開始: SELECT * FROM BOOK
        Root<Book> book = query.from(Book.class);
        
        // 查詢條件: author = ?
        Predicate authorName = cb.equal(book.get("author"), author);
        
        // 查詢條件: name like ?
        Predicate nameLike = cb.like(book.get("name"), "%" + keyword + "%");
        
        // 條件串接 author = ? and name like ?
        Predicate condition = cb.and(authorName, nameLike);
        
        // 串接所有物件
        query.select(book).where(condition);
        
        // 創建查詢
        TypedQuery<Book> typedQuery = entityManager.createQuery(query);
        
        // 執行查詢並獲取結果
        return typedQuery.getResultList();
	}

}
