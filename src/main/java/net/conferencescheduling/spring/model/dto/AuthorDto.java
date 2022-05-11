package net.conferencescheduling.spring.model.dto;

import lombok.Data;
import net.conferencescheduling.spring.model.entity.Paper;

import java.util.HashSet;
import java.util.Set;

@Data
public class AuthorDto {

    private String name;
    private String surname;
    private Set<PaperDto> papers=new HashSet<>();

}
