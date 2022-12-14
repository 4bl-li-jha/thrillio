package com.semanticsquare.thrillio.managers;

import com.semanticsquare.thrillio.dao.BookmarkDao;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.Movie;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.entities.WebLink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao= new BookmarkDao();
	private BookmarkManager() {

	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, int releaseYear, String[] cast,
			String[] directors, String genre, double imbdRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imbdRating);
		return movie;
	}

	public Book createBook(long id, String title, int publicationYear, String publisher,
			String[] authors, String genre, double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		return book;
	}

	public WebLink createWebLink(long id, String title,  String url, String host) {
		WebLink webLink=new WebLink();
		webLink.setId(id);
		webLink.setTitle(title);
		
		webLink.setUrl(url);
		webLink.setHost(host);
		return webLink;
	}
	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark= new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		dao.saveUserBookmark(userBookmark);
	}
}
