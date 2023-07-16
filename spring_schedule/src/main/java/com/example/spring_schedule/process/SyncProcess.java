package com.example.spring_schedule.process;

import com.example.spring_schedule.config.CommonConfig;
import com.example.spring_schedule.object.ProcessInfo;
import com.example.spring_schedule.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableScheduling
@Service
public class SyncProcess {
    @Autowired
    private ProcessService processService;
    @Autowired
    private CommonConfig config;

    @Scheduled(fixedDelay = 1000)
    public void process () {
        if ("true".equalsIgnoreCase(config.getProcessEnable())) {
            System.out.println("hello T2108E");
            ProcessInfo processInfo = new ProcessInfo("process_01", 1000);
            doProcess(processInfo);
        }
    }

    private void doProcess(ProcessInfo processInfo) {
        String processName = processInfo.getProcessName();
        Integer timout = processInfo.getProcessTimeout();
        if (processService.registerProcess(processName)) {
            Integer checkLockProcess = processService.checkLockProcess(processName, timout);
            if (checkLockProcess > 0) {
                if (processService.lockProcess(processName)) {
                    switch (processName) {
                        case "process_01" :
                            System.out.println(processName);
                            break;
                    }
                    processService.releaseProcess(processName);
                }
            }
        }

    }
}
