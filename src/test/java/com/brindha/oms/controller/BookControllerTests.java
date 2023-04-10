package com.brindha.oms.controller;

import com.brindha.oms.dto.AuthorDto;
import com.brindha.oms.dto.BookDto;
import com.brindha.oms.model.Author;
import com.brindha.oms.model.Book;
import com.brindha.oms.service.BookService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@WebMvcTest(value= BookController.class)
public class BookControllerTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BookService bookService;


    @Test
    public void testCreateBook() throws Exception{

        Book mockBook = new Book();
        mockBook.setId(354);
        mockBook.setName("2 states");
        mockBook.setDescription("A love story");
        mockBook.setYearOfPublication(2009);
        mockBook.setBookType("fiction");

        String inputInJason =this.mapToJson(mockBook);
        String URI = "/newbook";
        Mockito
                .when(bookService.createBook(Mockito.any(Book.class)))
                .thenReturn(mockBook);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                                            .post(URI)
                                            .accept(MediaType.APPLICATION_JSON).content(inputInJason)
                                            .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response =result.getResponse();

        String outputInJson =response.getContentAsString();

        assertThat(outputInJson).isEqualTo(inputInJason);
        assertEquals(HttpStatus.OK.value(),response.getStatus());

        }



     //Helper method
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
   }


}
