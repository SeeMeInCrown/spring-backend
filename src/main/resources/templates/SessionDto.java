//package net.conferencescheduling.spring.model.dto;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.Data;
//
//import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Date;
//
//@Data
//public class SessionDto {
//
//    @JsonFormat(pattern = "HH:mm", timezone="GMT+3")
//    private LocalTime sessionStartTime;
//    @JsonFormat(pattern = "HH:mm", timezone="GMT+3")
//    private LocalTime sessionEndTime;
//    @JsonFormat(pattern = "HH:mm", timezone="GMT+3")
//    private LocalTime sessionDuration;
//    private int sessionCount;
//    private int parallelSessionCount;
//    private ConstraintDto constraint;
//}
