package com.rustdetector.jobdata;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JobDataScheduler {
    @Scheduled(cron = "0 0 0 L * ?")
    public void scrapeJobData() {
        ProcessBuilder processBuilder = new ProcessBuilder("python", "rust-detector.py");
        try {
            Process process = processBuilder.start();
            System.out.println("Scraping data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}