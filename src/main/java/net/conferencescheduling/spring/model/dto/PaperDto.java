package net.conferencescheduling.spring.model.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

import java.util.List;

@Data
public class PaperDto {

    @CsvBindByPosition(position = 0)
    private String author;
    @CsvBindByPosition(position = 1)
    private String keyword;
    @CsvBindByPosition(position = 2)
    private String presenter;
    @CsvBindByPosition(position = 3)
    private String title;
}
