package net.conferencescheduling.spring.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import net.conferencescheduling.spring.model.entity.Author;
import net.conferencescheduling.spring.model.entity.Constraint;
import net.conferencescheduling.spring.model.entity.Presenter;

import java.util.HashSet;
import java.util.Set;

@Data
public class PaperDto {

    private Set<AuthorDto> authors=new HashSet<>();
    private ConstraintDto constraint;
    private PresenterDto presenter;
    private String title;
    private String keyword;
}
