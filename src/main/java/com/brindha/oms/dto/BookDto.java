package com.brindha.oms.dto;
import com.brindha.oms.model.Author;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDto {

    private int id;
    private String name;
    private String description;
    private Integer yearOfPublication;
    private String bookType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AuthorDto> authors ;
}
