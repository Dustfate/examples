package org.examples.spring.quartz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QuartzJob {
	
	@Scheduled(cron = "0/1 * *  * * ? ") // 每1秒执行一次
	public void bTask() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()) + "*********任务每1秒执行一次进入测试");
	}
	
}
