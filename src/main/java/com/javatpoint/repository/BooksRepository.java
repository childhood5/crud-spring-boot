package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;
import com.javatpoint.model.Books;

/**
 * Here is an BooksRepository interface 
 * 
 * @author phamrichard
 *
 */
public interface BooksRepository extends CrudRepository<Books, Integer> {
}
