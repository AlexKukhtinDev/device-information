package com.akukhtin.deviceinformationapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {
  private final int POOL_SIZE = 2;

  @Override
  public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();

    scheduler.setPoolSize(POOL_SIZE);
    scheduler.setThreadNamePrefix("name");
    scheduler.initialize();

    scheduledTaskRegistrar.setTaskScheduler(scheduler);
  }
}