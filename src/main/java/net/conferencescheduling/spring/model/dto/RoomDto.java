package net.conferencescheduling.spring.model.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class RoomDto {
    private int roomNumber;
    private int roomCapacity;
}
