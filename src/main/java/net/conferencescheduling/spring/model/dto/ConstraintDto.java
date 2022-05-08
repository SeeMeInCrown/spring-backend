package net.conferencescheduling.spring.model.dto;

import lombok.Data;


@Data
public class ConstraintDto {

    private int paperCount;
    private int breakCount;
    private String startDate;
    private String endDate;
    private int breakTime;

}
