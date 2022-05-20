package net.conferencescheduling.spring.model.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.conferencescheduling.spring.model.entity.Paper;
import java.time.LocalTime;

@Data
public class PresentationDto {

    private int dayNo;
    private int sessionNo;
    @JsonFormat(pattern = "HH:mm", timezone="GMT+3")
    private LocalTime start_time;
    @JsonFormat(pattern = "HH:mm", timezone="GMT+3")
    private LocalTime end_time;
    private int roomNo;
    private Paper paper;
}
