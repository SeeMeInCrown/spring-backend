package net.conferencescheduling.spring.model.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;


@Data
public class InfoDto {

    @CsvBindByPosition(position = 0)
    private int dayNo;
    @CsvBindByPosition(position = 1)
    private String dayStart;
    @CsvBindByPosition(position = 2)
    private String dayEnd;
    @CsvBindByPosition(position = 3)
    private int sessionCount;
    @CsvBindByPosition(position = 4)
    private int sessionDuration;
}
