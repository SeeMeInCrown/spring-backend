package net.conferencescheduling.spring.model.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.conferencescheduling.spring.model.entity.Paper;
import java.time.LocalTime;

@Data
public class PresentationDto {


    @CsvBindByPosition(position = 0)
    private int dayNo;
    @CsvBindByPosition(position = 1)
    private int sessionNo;
    @CsvBindByPosition(position = 2)
    private String authors;
    @CsvBindByPosition(position = 3)
    private String presenter;
    @CsvBindByPosition(position = 4)
    private String title;
    @CsvBindByPosition(position = 5)
    private String keyword;
    @CsvBindByPosition(position = 6)
    private String start_time;
    @CsvBindByPosition(position = 7)
    private String end_time;




}
