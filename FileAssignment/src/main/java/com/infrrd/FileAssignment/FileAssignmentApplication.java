package com.infrrd.FileAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.infrrd.FileAssignment.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FileAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileAssignmentApplication.class, args);
	}

}
