/**
 * 
 */
package movie.review.service.dao;

import java.util.List;

/**
 * @author anoop
 *
 */

import movie.review.service.domain.*;

public interface MovieDAO {

	public boolean addMovie(Movie movie);

	public List<Movie> getAllMovies();

	public Movie getMovieByName(String movieName);

}
