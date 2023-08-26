package com.example.spring_schedule.service.impl;

import com.example.spring_schedule.entity.Process;
import com.example.spring_schedule.repository.ProcessRepository;
import com.example.spring_schedule.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private ProcessRepository processRepository;

    @Override
    public Process findByName(String name) {
        return processRepository.findByName(name);
    }

    @Override
    public void saveProcess(Process process) {
        processRepository.save(process);
    }

    @Override
    public boolean registerProcess(String processName) {
        try {
            Process p = this.findByName(processName);
            if (p == null) {
                Process process = new Process();
                process.setName(processName);
                process.setProcessId(0);
                process.setProcessCreatedAt(Timestamp.from(Instant.now()));
                this.saveProcess(process);
            }
            return true;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return  false;
    }

    @Override
    @Transactional
    public Integer checkLockProcess(String processName, Integer timeout) {
        Process p =  processRepository.checkLockProcess(processName, timeout);
        if (p != null) {
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    @Transactional
    public boolean lockProcess(String processName) {
        try {
            processRepository.lockProcess(processName);
            return  true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    @Override
    @Transactional
    public void releaseProcess(String processName) {
        processRepository.releaseProcess(processName);
    }
}
