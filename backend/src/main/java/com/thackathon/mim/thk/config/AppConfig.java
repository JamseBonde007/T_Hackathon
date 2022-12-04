package com.thackathon.mim.thk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.thackathon")
@Import({ MessagingConfiguration.class, MessagingListenerConfiguration.class })
public class AppConfig {


}
