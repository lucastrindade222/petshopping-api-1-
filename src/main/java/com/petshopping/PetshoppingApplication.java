package com.petshopping;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class PetshoppingApplication implements CommandLineRunner  {
	 
//	@Autowired
//	private AmazonS3 amazonS3;
//	
//	@Value("${s3.bucket}")
//	private String bucket;
	
	public static void main(String[] args) {
		SpringApplication.run(PetshoppingApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		
//		File file = new File("C:\\Users\\lucas\\OneDrive\\Imagens\\wappeper\\koe-no-katachi-wallpapers-25939-1985666.png");
//		amazonS3.putObject(new PutObjectRequest(bucket, "test.png", file));
	}

	
	

}
