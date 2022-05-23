package net.conferencescheduling.spring.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalTime;

@Data
public class ConstraintDto {

    private int dayNo;
    private int parallelSessionCount;
    private int sessionNo;

    //@JsonFormat(pattern = "HH:mm", timezone="GMT+3")
    private String startTime;

    //@JsonFormat(pattern = "HH:mm", timezone="GMT+3")
    private String endTime;

    //@JsonFormat(pattern = "HH:mm", timezone="GMT+3")
    private String presentationDuration;

}
