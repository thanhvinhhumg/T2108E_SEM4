package com.example.spring_schedule.repository;

import com.example.spring_schedule.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProcessRepository extends JpaRepository<Process, Long> {
    Process findByName(String name);

    @Query(value = "select * from process where name = :processName and ( process_id = 0 or (process_id = 1 and TIMEDIFF(now(), process_created_at) >:timeout))", nativeQuery = true)
    Process checkLockProcess(String processName, Integer timeout);

    @Modifying
    @Query(value = "update process set process_id = 1 where name = :processName", nativeQuery = true)
    void lockProcess(String processName);

    @Modifying
    @Query(value = "update process set process_id = 0, process_created_at = now() where name = :processName", nativeQuery = true)
    void releaseProcess(String processName);
}
