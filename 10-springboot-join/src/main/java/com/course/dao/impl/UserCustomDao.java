package com.course.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course.dto.UserRptDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

// 沒有繼承JpaRepository，需要宣告成Repository讓Spring管理
@Repository
public class UserCustomDao {
	
	// 注入EntityManager
	@Autowired
    private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<UserRptDto> getOrderDetailByUserId(Long userId) {
		
		StringBuilder sql = new StringBuilder();
	
		sql.append("SELECT ");
		sql.append("U.ID USERID, ");
		sql.append("U.NAME USERNAME, ");
		sql.append("O.ID ORDERID, ");
		sql.append("T.PRODUCT_NAME PRODUCTNAME, ");
		sql.append("T.PRODUCT_PRICE PRODUCTPRICE ");
		sql.append("FROM USER U ");
		sql.append("JOIN ORDERS O ON O.USER_ID = U.ID ");
		sql.append("JOIN ORDER_ITEM T ON T.ORDER_ID = O.ID ");
		sql.append("WHERE U.ID = ?1");
		// 對應到OrderProductDto類別當中，在@SqlResultSetMapping設定的name
		Query query = entityManager.createNativeQuery(sql.toString(), "UserCustomRptDtoMapping");
		query.setParameter(1, userId);

		List<UserRptDto> resultList = query.getResultList();
		return resultList;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRptDto> getOrderDetailByCondition(Long userId, Integer price) {
		
		StringBuilder sql = new StringBuilder();
	
		sql.append("SELECT ");
		sql.append("U.ID USERID, ");
		sql.append("U.NAME USERNAME, ");
		sql.append("O.ID ORDERID, ");
		sql.append("T.PRODUCT_NAME PRODUCTNAME, ");
		sql.append("T.PRODUCT_PRICE PRODUCTPRICE ");
		sql.append("FROM USER U ");
		sql.append("JOIN ORDERS O ON O.USER_ID = U.ID ");
		sql.append("JOIN ORDER_ITEM T ON T.ORDER_ID = O.ID ");
		// 常看到在有像是 "WHERE 1 = 1"的SQL語句，這是讓後續的SQL不需要考慮是用 WHERE 還是 AND 開頭
		// 只要固定為TRUE，比較好的做法是用不可能為 NULL 的欄位來撰寫
		sql.append("WHERE U.ID IS NOT NULL ");
		sql.append("AND U.ID = ?1 ");
		if (price != null) {
			// 當條件成立時，動態加入SQL語句
			sql.append("AND T.PRODUCT_PRICE > ?2");
		}
		
		// 對應到OrderProductDto類別當中，在@SqlResultSetMapping設定的name
		Query query = entityManager.createNativeQuery(sql.toString(), "UserCustomRptDtoMapping");
		query.setParameter(1, userId);
		
		if (price != null) {
			query.setParameter(2, price);
		}

		List<UserRptDto> resultList = query.getResultList();
		return resultList;
	}

}
