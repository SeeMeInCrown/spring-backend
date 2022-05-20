package net.conferencescheduling.spring.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaperDto {

    private List<AuthorDto> authors;
    private List<KeywordDto> keywords;
    private PresenterDto presenter;
    private String title;
}
