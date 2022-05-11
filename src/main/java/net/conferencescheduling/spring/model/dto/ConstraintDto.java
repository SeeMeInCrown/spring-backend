package net.conferencescheduling.spring.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.conferencescheduling.spring.model.entity.Paper;
import net.conferencescheduling.spring.model.entity.Room;
import net.conferencescheduling.spring.model.entity.Session;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
public class ConstraintDto {

    private int paperCount;
    private int breakCount;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="Turkey")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone ="Turkey")
    private LocalDate endDate;

    @JsonFormat(pattern = "HH:mm", timezone="GMT+3")
    private LocalTime breakTime;
    private Set<PaperDto> papers = new HashSet<>();
    private Set<RoomDto> rooms = new HashSet<>();
    private Set<SessionDto> sessions = new HashSet<>();

}
