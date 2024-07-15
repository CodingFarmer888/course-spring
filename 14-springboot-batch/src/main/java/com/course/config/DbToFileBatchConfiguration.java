package com.course.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.course.entity.Person;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class DbToFileBatchConfiguration {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	ItemReader<Person> jpaReader() {
		JpaCursorItemReader<Person> itemReader = new JpaCursorItemReader<>();
		itemReader.setEntityManagerFactory(entityManagerFactory);
		itemReader.setName("JPA-Reader");
		itemReader.setQueryString("select p from Person p");
		return itemReader;
	}
	
	// ItemProcessor 直接沿用，無需調整 
	@Bean
	ItemProcessor<Person, Person> toFileProcessor() {
		return new CsvItemProcessor(); 
	}
	
	@Bean
	ItemWriter<Person> csvWriter() {
		// LineAggregator 與 LineMapper 的作用相反，要將物件的資料打成 String
		BeanWrapperFieldExtractor<Person> fieldExtractor = new BeanWrapperFieldExtractor<>();
		fieldExtractor.setNames(new String[] {"name", "gender", "city"});
		fieldExtractor.afterPropertiesSet();

		DelimitedLineAggregator<Person> lineAggregator = new DelimitedLineAggregator<>();
		lineAggregator.setDelimiter(",");
		lineAggregator.setFieldExtractor(fieldExtractor);
		
		return  new FlatFileItemWriterBuilder<Person>()
       			.name("CSV-Writer")
       			.resource(new FileSystemResource("target/test-outputs/output.txt"))
       			.lineAggregator(lineAggregator)
       			.build();
	}
	
	@Bean
	Step csvStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		Step step = new StepBuilder("CSV-Step", jobRepository)
				.<Person, Person>chunk(2, transactionManager)
				.reader(jpaReader())
				.processor(toFileProcessor())
				.writer(csvWriter())
				.build();
		return step;
	}
	
	@Bean
	Job csvJob(JobRepository jobRepository, Step csvStep) {
		Job job = new JobBuilder("CSV-Job", jobRepository)
		.start(csvStep)
		.build();
		return job;
	}
	
}
