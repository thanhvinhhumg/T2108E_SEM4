package com.example.spring_schedule.service;

import com.example.spring_schedule.entity.Process;
import org.springframework.stereotype.Service;

public interface ProcessService {
    Process findByName(String name);
    void saveProcess(Process process);

    boolean registerProcess(String processName);
    Integer checkLockProcess(String processName, Integer timeout);
    boolean lockProcess(String processName);
    void releaseProcess(String processName);
}
