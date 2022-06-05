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
    private int parallelSessionNo;
    @CsvBindByPosition(position = 3)
    private String authors;
    @CsvBindByPosition(position = 4)
    private String presenter;
    @CsvBindByPosition(position = 5)
    private String title;
    @CsvBindByPosition(position = 6)
    private String keywords;
    @CsvBindByPosition(position = 7)
    private String start_time;
    @CsvBindByPosition(position = 8)
    private String end_time;





}
