/**
 * 
 */
package movie.review.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anoop
 *
 */

import movie.review.service.dao.*;
import movie.review.service.domain.Movie;

public class MovieDaoImpl implements MovieDAO {

	private static List<Movie> movies = new ArrayList<Movie>();

	public boolean addMovie(Movie movie) {
		boolean status = true;
		if (movies.contains(movie))
			status = false;
		else
			movies.add(movie);
		return status;
	}

	public List<Movie> getAllMovies() {
		List<Movie> result = new ArrayList<Movie>(movies);
		return result;
	}

	public Movie getMovieByName(String movieName) {
		for(Movie movie: movies) {
			if(movie.getMovieName().equalsIgnoreCase(movieName))
				return movie;
		}
		return null;
	}

}
