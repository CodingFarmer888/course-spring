package com.course.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("personJob")
	private Job job;
	
	/**
	 * 固定間隔時間啟動
	 */
	// @Scheduled(fixedRate = 2000)
	public void repeatFixedRate() {
		logger.info(dateFormat.format(new Date()));
	}
	
	/**
	 * 執行完後，固定時間再啟動
	 */
	// @Scheduled(fixedDelay = 5000)
	public void repeatFixedDelay() {
		logger.info(dateFormat.format(new Date()));
	}
	
	/**
	 * Cron 表達式
	 * 秒 分 時 日 月 星期 [年]
	 */
	// @Scheduled(cron = "0-15,30,45 * * 10 * ?")
	public void executeTask() {
		logger.info("Cron Task: " + dateFormat.format(new Date()));
	}
	
	// @Scheduled(cron = "0/10 * * * * ?")
	public void executeJobLauncherTask() throws Exception {
		logger.info("Cron Task: " + dateFormat.format(new Date()));
		JobParameters jobParams = new JobParametersBuilder()
				.addLong("Start-At", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(job, jobParams);
	}
}
