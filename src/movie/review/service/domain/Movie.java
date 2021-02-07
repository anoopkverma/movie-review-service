/**
 * 
 */
package movie.review.service.domain;

import java.util.List;

/**
 * @author anoop
 *
 */
public class Movie {

	private String movieName;
	private int releaseYear;
	private List<String> genre;

	public Movie(String movieName, int releaseYear, List<String> genre) {
		super();
		this.movieName = movieName;
		this.releaseYear = releaseYear;
		this.genre = genre;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

}
