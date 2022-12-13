package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1
		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, "Philosophy", 4.3);
		boolean isKidFriendlyEligible=book.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible, "For Philosophy Genre- isKidFriendly should return false");
		
		// Test 2
		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, "Self Help", 4.3);
		isKidFriendlyEligible=book.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible, "For Self Help Genre- isKidFriendly should return false");
	}

}
