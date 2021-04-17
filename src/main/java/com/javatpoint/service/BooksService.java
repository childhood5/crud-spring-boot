package com.javatpoint.service;

import java.util.List;

import com.javatpoint.model.Books;

/**
 * Define book service
 * 
 * @author phamrichard
 *
 */
public interface BooksService {
	
	//Getting all books record by using the method findaAll() of CrudRepository
	public List<Books> getAllBooks();

	//Getting a specific record by using the method findById() of CrudRepository
	public Books getBooksById(int id);
	
	//Saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Books books);

	//Deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id);

	//Updating a record
	public void update(Books books, int bookid);
}