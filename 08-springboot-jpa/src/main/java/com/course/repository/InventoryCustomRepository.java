package com.course.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course.dto.InventoryDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class InventoryCustomRepository {
	
    // 注入EntityManager
    @Autowired
    private EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
    public List<InventoryDto> getInventoryRpt(String productCode) {
    	
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("I.ID ID, ");
        sql.append("P.NAME PRODUCTNAME, ");
        sql.append("S.STORE_NAME STORENAME, ");
        sql.append("I.QUANTITY QUANTITY ");
        sql.append("FROM INVENTORY I ");
        sql.append("JOIN STORE S ON S.ID = I.STORE_ID ");
        sql.append("JOIN PRODUCT P ON P.ID = I.PRODUCT_ID ");
        sql.append("WHERE P.CODE = ?1");
        // 對應到InventoryDto類別當中，在@SqlResultSetMapping設定的name
        Query query = entityManager.createNativeQuery(sql.toString(), "InventoryCustomDtoMapping");
        // 參數設定
        query.setParameter(1, productCode);

        List<InventoryDto> resultList = query.getResultList();
        return resultList;
    }
}
