package net.conferencescheduling.spring.model.dto;

import lombok.Data;
import net.conferencescheduling.spring.model.entity.Author;
import net.conferencescheduling.spring.model.entity.Constraint;
import net.conferencescheduling.spring.model.entity.Presenter;

import java.util.HashSet;
import java.util.Set;

@Data
public class PaperDto {

    private Set<Author> authors=new HashSet<>();
    private Constraint constraint;
    private Presenter presenter;
    private String title;
    private String keyword;
}
