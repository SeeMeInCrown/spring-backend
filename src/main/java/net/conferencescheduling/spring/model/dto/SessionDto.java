package net.conferencescheduling.spring.model.dto;

import lombok.Data;
import net.conferencescheduling.spring.model.entity.Constraint;

@Data
public class SessionDto {

    private String sessionStartTime;
    private String sessionEndTime;
    private int sessionDuration;
    private int sessionCount;
    private int parallelSessionCount;
    private Constraint constraint;
}
