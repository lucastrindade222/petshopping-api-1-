package com.petshopping.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
 
@Configuration
public class AmazonS3Config {

	@Value("${aws.access_key_id}")
	private String accesKeyId;
	@Value("${aws.secret_access_key}")
	private String secretaccesskey;
	@Value("${s3.region}")
	private String region;
	
	@Bean
	public AmazonS3 getAmazonS3() {
		BasicAWSCredentials awsCredentials =
				new BasicAWSCredentials(accesKeyId, secretaccesskey);
		AmazonS3 amazon3 = AmazonS3ClientBuilder.standard().withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
		return amazon3;
	
	}
	
	
}
