package com.omniwyse.sms.ischool;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CreateBucketRequest;

@Service
public class S3BucketService {

	@SuppressWarnings("deprecation")
	public int creatinBucketInS3(AmazonS3Client s3client, String bucketName) {
		s3client.setRegion(Region.getRegion(Regions.US_WEST_1));

		try {
			if (!(s3client.doesBucketExist(bucketName))) {
				s3client.createBucket(new CreateBucketRequest(bucketName));
				return 1;
			}
			return 0;
		} catch (AmazonServiceException ase) {
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			return -1;
		} catch (AmazonClientException ace) {
			// aught an AmazonClientException, which means the client
			// encountered an
			// internal error while trying to communicate with S3, such as not
			// being able to access the network.
			System.out.println("Error Message: " + ace.getMessage());
			return -2;
		}
	}

}