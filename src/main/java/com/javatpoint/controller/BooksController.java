package com.javatpoint.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.dto.SearchRequest;
import com.javatpoint.exception.ApiError;
import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;
import com.javatpoint.util.ValidatorUtil;

/**
 * Here is controller class
 * 
 * @author phamrichard
 *
 */
@RestController
@RequestMapping(value = "/api/v2.0", produces = { "application/json", "application/xml" })
public class BooksController {

	private BooksService booksService;

	/**
	 * Initial constructor of controller
	 * 
	 * @param booksService
	 */
	@Autowired
	public BooksController(BooksService booksService) {
		this.booksService = booksService;
	}

	/**
	 * Creating a get mapping that retrieves all the books detail from the database
	 * 
	 * @return all the books
	 */
	@GetMapping("/book")
	public ResponseEntity<?> getAllBooks() {
		try {
			return new ResponseEntity<>(booksService.getAllBooks(), HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}
	}

	/**
	 * Creating a get mapping that retrieves the detail of a specific book by bookid
	 * 
	 * @param modelSearchRequest
	 * @param result
	 * @return detail of the book
	 */
	@GetMapping("/book/{bookid}")
	public ResponseEntity<?> getBooks(@Valid SearchRequest modelSearchRequest, BindingResult result) {
		try {
			ValidatorUtil.validateSearchRequest(result);
			return new ResponseEntity<>(booksService.getBooksById(modelSearchRequest.getBookid()), HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}

	}

	/**
	 * Creating a get mapping that retrieves the detail of a specific book by author
	 * 
	 * @param modelSearchRequest
	 * @param result
	 * @return detail of the book by author
	 */
	@GetMapping("/book-detail/{author}")
	public ResponseEntity<?> getBookByAuthor(@Valid SearchRequest modelSearchRequest, BindingResult result) {
		try {
			ValidatorUtil.validateSearchRequest(result);
			List<Books> books = booksService.getAllBooks().stream()
					.filter(book -> modelSearchRequest.getAuthor().equals(book.getAuthor()))
					.collect(Collectors.toList());
			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}

	}

	/**
	 * Creating a delete mapping that deletes a specified book
	 * 
	 * @param modelSearchRequest
	 * @param result
	 * @return id of the book
	 */
	//
	@DeleteMapping("/book/{bookid}")
	public ResponseEntity<?> deleteBook(@Valid SearchRequest modelSearchRequest, BindingResult result) {
		try {
			ValidatorUtil.validateSearchRequest(result);
			booksService.delete(modelSearchRequest.getBookid());
			return new ResponseEntity<>(modelSearchRequest.getBookid(), HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}

	}

	/**
	 * Creating post mapping that post the book detail in the database
	 * 
	 * @param books
	 * @return id of the book
	 */
	@PostMapping("/books")
	public ResponseEntity<?> saveBook(@Valid @RequestBody Books books, BindingResult result) {
		try {
			booksService.saveOrUpdate(books);
			return new ResponseEntity<>(books.getBookid(), HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}
	}

	/**
	 * Creating put mapping that updates the book detail
	 * 
	 * @param books
	 * @return the book after update
	 */
	@PutMapping("/books")
	public ResponseEntity<?> update(@Valid @RequestBody Books books, BindingResult result) {
		try {
			booksService.saveOrUpdate(books);
			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, e.getLocalizedMessage());
			return new ResponseEntity<>(apiError, apiError.getStatus());
		}
	}
}
