package com.brindha.oms.controller;

import com.brindha.oms.dto.BookDto;
import com.brindha.oms.model.Book;
import com.brindha.oms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController

public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = {"/newbook"},method= RequestMethod.POST)
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

//    @GetMapping(value = {"/bookList"})
//    public String getbookList(Model model) {
//        List<Book> books= bookService.listBooks();
//        model.addAttribute("books",books);
//        return "bookList";
//    }

    @RequestMapping(value = {"/bookList"},method= RequestMethod.GET)
    public List<Book> getbookList() {
        return bookService.listBooks();

    }

    @RequestMapping(value = "/getAllBooks,",method= RequestMethod.GET)
    public List<Book> getAllBooksByOptionalYop(@RequestParam (value = "yearOfPublication", required = false) Integer yop) {

        return bookService.getAllBooks(yop);
    }


    @RequestMapping(value = "/getBooks",method= RequestMethod.GET)
    public List<Book> getBooksWithYopAndBookType(
                                @RequestParam(value = "yearOfPublications", required = false) Set<Integer> yop,
                                @RequestParam(value = "bookType", required = false) String bookType) {

        return bookService.getBooks(yop, bookType);
    }

    @RequestMapping(value = "/books/{id}",method= RequestMethod.GET)
    public BookDto getBookByIdWithOrWithoutAuthor(@PathVariable("id") int bookId ,
                               @RequestParam (value = "authorData",required = false) boolean authorData) {
        return bookService.getBookById(bookId,authorData);
    }

    @RequestMapping(value = "/updatebook",method= RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return book;
    }

    @RequestMapping(value = "/deletebook/{bookId}",method= RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBookById(bookId);
        return "Deleted Successfully";
    }



}
