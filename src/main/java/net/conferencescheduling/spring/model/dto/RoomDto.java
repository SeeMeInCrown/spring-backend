package net.conferencescheduling.spring.model.dto;

import lombok.Data;
import net.conferencescheduling.spring.model.entity.Constraint;

@Data
public class RoomDto {

    private int roomNo;
    private int roomCount;
    private Constraint constraint;
}
