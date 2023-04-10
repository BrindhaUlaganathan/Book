package com.brindha.oms.service;


import com.brindha.oms.dto.AuthorDto;
import com.brindha.oms.dto.BookDto;
import com.brindha.oms.model.Author;
import com.brindha.oms.model.Book;
import com.brindha.oms.model.BookAuthor;
import com.brindha.oms.repository.BookAuthorRepository;
import com.brindha.oms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookAuthorRepository bookAuthorRepository;

    //Create

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    //Read

    public List<Book> listBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> books.add(book));
        return books;
    }

    //
    public List<Book> getBooks(Set<Integer> yop, String bookType) {
        List<Book> bookList = new ArrayList<>();
        if (yop == null) {
            bookRepository.findAll()
                    .forEach(book -> bookList.add(book));
        } else {
            return bookRepository.findAllByYearOfPublicationInAndBookType(yop, bookType);
        }
        return bookList;
    }

    //

    public List<Book> getAllBooks(Integer yop){
        List<Book> bookList = new ArrayList<>();
        if (yop == null) {
                bookRepository.findAll()
                        .forEach(book -> bookList.add(book));
            return bookList;
        } else {
             return bookRepository.findByYearOfPublication(yop);
        }

    }

    //

    public Optional<Book> getOneBookById(int bookId){
        Optional<Book> book= bookRepository.findById(bookId);
        return book;
    }

    //
    public BookDto getBookById(int bookId, boolean authorData){
        List<BookAuthor> bookAuthors = null;
        Book book;
        book = bookRepository.findById(bookId).orElse(null);
        if(authorData){
           bookAuthors= bookAuthorRepository.findAllByBookId(bookId);
            System.out.println("bookAuthors");
        }

        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setDescription(book.getDescription());
        bookDto.setYearOfPublication(book.getYearOfPublication());
        bookDto.setBookType(book.getBookType());

        // get author details
        List<AuthorDto> authorDTOList = new ArrayList<AuthorDto>();
        if (bookAuthors != null) {
            for (BookAuthor bookAuthor : bookAuthors) {
                Author author = bookAuthor.getAuthor();
                AuthorDto authorDTO = new AuthorDto();
                authorDTO.setId(author.getId());
                authorDTO.setName(author.getName());
                authorDTO.setGender(author.getGender());
                authorDTOList.add(authorDTO);
            }

            // set author details
            bookDto.setAuthors(authorDTOList);
        }
        return bookDto;
    }


    //Update
    public Book updateBook(Book book) {

        return bookRepository.save(book);
    }
    //Delete
    public String deleteBookById(int bookId){

        bookRepository.deleteById(bookId);
        return "Deleted Successfully";
    }
}