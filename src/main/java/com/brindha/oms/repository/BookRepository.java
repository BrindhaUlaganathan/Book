package com.brindha.oms.repository;

import com.brindha.oms.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAllByYearOfPublicationInAndBookType(Set<Integer> yop, String bookType);

    List<Book> findByYearOfPublication(Integer yop);

//    String rawQuery = "select * from book where year_of_publication IN ?1";
//    @Query(nativeQuery = true, value = rawQuery)
//    List<Book> findAllByYearOfPublicationIn( Set<Integer> yop);


}
