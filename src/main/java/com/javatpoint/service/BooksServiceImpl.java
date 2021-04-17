package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Books;
import com.javatpoint.repository.BooksRepository;

/**
 * Here is an BooksServiceImpl class
 * 
 * @author phamrichard
 *
 */
@Service
public class BooksServiceImpl implements BooksService {

	private BooksRepository booksRepository;

	@Autowired
	public BooksServiceImpl(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}

	// Getting all books record by using the method findaAll() of CrudRepository
	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books::add);
		return books;
	}

	// Getting a specific record by using the method findById() of CrudRepository
	public Books getBooksById(int id) {
		return booksRepository.findById(id).get();
	}
	
	// Saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Books books) {
		booksRepository.save(books);
	}

	// Deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id) {
		booksRepository.deleteById(id);
	}

	// Updating a record
	public void update(Books books, int bookid) {
		booksRepository.save(books);
	}
}