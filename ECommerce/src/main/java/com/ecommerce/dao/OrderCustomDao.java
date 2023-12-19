package com.ecommerce.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.model.dto.OrderProductDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class OrderCustomDao implements OrderCustom {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderProductDto> getOrdersByCondition(String customerId, String startDate, String endDate) {
		
		StringBuilder sb = new StringBuilder();
		// 由於DB的欄位可以會增減，這裡使用＊來抓的話，有可能會有對應不到的情況
		// 所以這裡分別抓取個欄位
		sb.append("SELECT ");		
		sb.append("OP.ORDER_PRODUCT_KEY AS ORDERPRODUCTKEY, ");
		sb.append("O.ORDER_KEY AS ORDERKEY, ");
		sb.append("C.NAME AS CUSTOMERNAME, ");
		sb.append("P.NAME AS PRODUCTNAME, ");
		sb.append("OP.PRODUCT_QTY AS PRODUCTQTY, ");
		sb.append("O.TOTAL_AMOUNT AS TOTALAMOUNT, ");
		sb.append("O.ORDER_DATE AS ORDERDATE ");
		sb.append("FROM ORDER_ITEM O ");
		sb.append("JOIN ORDER_PRODUCT OP ON OP.ORDER_KEY = O.ORDER_KEY ");
		sb.append("JOIN PRODUCT P ON P.PRODUCT_KEY = OP.PRODUCT_KEY ");
		sb.append("JOIN CUSTOMER C ON C.CUSTOMER_KEY = O.CUSTOMER_KEY ");
		sb.append("WHERE C.CUSTOMER_ID = :CUSTOMERID ");
		sb.append("AND O.ORDER_DATE BETWEEN :STARTDATE AND :ENDDATE ");
		// 這裡無法使用class來 Mapping，不知道為什麼
		// Query query = entityManager.createNativeQuery(sb.toString(), OrderProductDto.class);
		Query query = entityManager.createNativeQuery(sb.toString(), "OrderProductDtoMapping");
		query.setParameter("CUSTOMERID", customerId);
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = null;
        Date end = null;
		try {
			start = dateFormat.parse(startDate + " 00:00:00");
			end = dateFormat.parse(endDate + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		query.setParameter("STARTDATE", new java.sql.Date(start.getTime()));
		query.setParameter("ENDDATE", new java.sql.Date(end.getTime()));
		List<OrderProductDto> resultList = query.getResultList();
		return resultList;
	}

}
