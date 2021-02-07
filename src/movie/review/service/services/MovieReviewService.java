/**
 * 
 */
package movie.review.service.services;

import java.util.List;

import movie.review.service.Exceptions.MovieNotReleasedException;
import movie.review.service.Exceptions.MultipleReviewException;
import movie.review.service.domain.Movie;
import movie.review.service.domain.MovieReview;
import movie.review.service.domain.User;

/**
 * @author anoop
 *
 */
public interface MovieReviewService {

	public boolean addMovie(Movie movie);

	public boolean addReview(MovieReview movieReview) throws MultipleReviewException, MovieNotReleasedException;

	public boolean addUser(User user);

	public List<String> getTopMoviesByCritics(int n, String genre);

	public double getAvgReviewScoreByYear(int year);

	public double getAvgReviewScoreMovie(String movieName);

}
