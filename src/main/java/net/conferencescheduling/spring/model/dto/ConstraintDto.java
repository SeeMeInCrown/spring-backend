package net.conferencescheduling.spring.model.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class ConstraintDto {

    @CsvBindByPosition(position = 0)
    private int dayNo;
    @CsvBindByPosition(position = 1)
    private int parallelSessionCount;
    @CsvBindByPosition(position = 2)
    private int presentationDuration;
    @CsvBindByPosition(position = 3)
    private int sessionDuration;
    @CsvBindByPosition(position = 4)
    private int sessionNo;
    @CsvBindByPosition(position = 5)
    private String startTime;
    @CsvBindByPosition(position = 6)
    private String endTime;


}
