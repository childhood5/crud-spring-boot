package com.javatpoint.dto;

import javax.validation.constraints.Pattern;

import com.javatpoint.constants.RegexConstant;

/**
 * Class search request
 * 
 * @author phamrichard
 *
 */
public class SearchRequest {

	// Pattern for bookId
	@Pattern(regexp = RegexConstant.BOOK_ID_PATTERN)
	private int bookid;
	
	// Pattern for author
	@Pattern(regexp = RegexConstant.AUTHOR_PATTERN)
	private String author;
	
	// Get BookId
	public int getBookid() {
		return bookid;
	}

	// Set bookId
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	// Get author
	public String getAuthor() {
		return author;
	}

	// Set author
	public void setAuthor(String author) {
		this.author = author;
	}
}
