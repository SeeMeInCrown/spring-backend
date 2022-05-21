package net.conferencescheduling.spring.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class ConstraintDto {

    private int dayNo;
    private int parallelSessionCount;
    private int sessionCount;

    @JsonFormat(pattern = "HH:mm", timezone="GMT+3")
    private LocalTime startTime;

    @JsonFormat(pattern = "HH:mm", timezone="GMT+3")
    private LocalTime endTime;

    @JsonFormat(pattern = "HH:mm", timezone="GMT+3")
    private LocalTime sessionDuration;

    @JsonFormat(pattern = "HH:mm", timezone="GMT+3")
    private LocalTime presentationDuration;

//    private int startTime;
//    private int endTime;
//    private int sessionDuration;
//    private int presentationDuration;
    //List<PaperDto> papers = new ArrayList<>();
}
