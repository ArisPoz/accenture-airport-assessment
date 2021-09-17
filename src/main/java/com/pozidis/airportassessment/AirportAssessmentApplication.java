package com.pozidis.airportassessment;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AirportAssessmentApplication {

	private final JobLauncher jobLauncher;
	private final Job job;

	public AirportAssessmentApplication(JobLauncher jobLauncher, Job job) {
		this.jobLauncher = jobLauncher;
		this.job = job;
	}

	public static void main(String[] args) {
		SpringApplication.run(AirportAssessmentApplication.class, args);
	}

	@PostConstruct
	public void perform() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
		JobParameters params = new JobParametersBuilder()
				.addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(job, params);
	}

}
