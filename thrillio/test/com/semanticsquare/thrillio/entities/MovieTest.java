package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1
		Movie movie =BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles,Joseph Cotten" }, new String[] { "Orson Welles" }, "Horror", 8.5);
		boolean isKidFriendlyEligible= movie.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible, "For Horror Genre- isKidFriendlyEligible should return false");
		// Test 2
		movie =BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles,Joseph Cotten" }, new String[] { "Orson Welles" }, "Thrillers", 8.5);
		isKidFriendlyEligible= movie.isKidFriendlyEligible();
		assertFalse(isKidFriendlyEligible, "For Thrillers Genre- isKidFriendlyEligible should return false");
	}

}
