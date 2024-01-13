package com.fiap.burger.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@EnableSqs
@Configuration
public class AwsSQSConfigurationTest
{
    @Value("${cloud.aws.region}")
    private String awsRegion;
    @Value("${cloud.aws.end-point.uri}")
    private String awsEndpointUri;
}