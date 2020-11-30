package com.akukhtin.deviceinformationapplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {
  @Value(value = "${pool.size}")
  private int POOL_SIZE;

  @Override
  public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();

    scheduler.setPoolSize(POOL_SIZE);
    scheduler.setThreadNamePrefix("job");
    scheduler.initialize();

    scheduledTaskRegistrar.setTaskScheduler(scheduler);
  }
}
