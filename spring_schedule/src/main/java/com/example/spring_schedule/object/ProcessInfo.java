package com.example.spring_schedule.object;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProcessInfo {
    private String processName;
    private Integer processTimeout;
}
