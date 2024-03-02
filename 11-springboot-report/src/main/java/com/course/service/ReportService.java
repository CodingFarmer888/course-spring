package com.course.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.course.entity.ProductEntity;
import com.course.repository.ProductRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	private ProductRepository repository;
	
	public String exportReport(String formatType) throws FileNotFoundException, JRException {
		List<ProductEntity> products = repository.findAll();
		
		// 讀取jrxml
		File file = ResourceUtils.getFile("classpath:products.jrxml");
		
		// 編譯報表
		JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
		
		Map<String, Object> params = new HashMap<>();
		params.put("createBy", "Guybrush");
		JasperPrint print = JasperFillManager.fillReport(report, params, dataSource);
		
		if (formatType.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(print, "/Users/guybrush/Report" + "/products.pdf");
		} else if (formatType.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(print, "/Users/guybrush/Report" + "/products.html");
		}
		return "Report Complete";
	}
}
