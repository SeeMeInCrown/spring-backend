package net.conferencescheduling.spring.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalTime;

@Data
public class ConstraintDto {

    private int dayNo;
    private int parallelSessionCount;
    private int presentationDuration;
    private int sessionDuration;
    private int sessionNo;
    private String startTime;
    private String endTime;


}
