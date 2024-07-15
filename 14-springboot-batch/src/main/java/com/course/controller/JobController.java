package com.course.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("personJob")
	private Job personJob;
	
	@Autowired
	@Qualifier("csvJob")
	private Job csvJob;
	
	@GetMapping("/csvToDbLauncher")
	public void csvToDb() throws Exception {
		JobParameters jobParams = new JobParametersBuilder()
				.addLong("Start-At", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(personJob, jobParams);
	}
	
	@GetMapping("/dbToCsvLauncher")
	public void dbToCsv() throws Exception {
		JobParameters jobParams = new JobParametersBuilder()
				.addLong("Start-At", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(csvJob, jobParams);
	}
}
