package com.course.repository;

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

}
