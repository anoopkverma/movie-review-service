/**
 * 
 */
package movie.review.service.controller;

import java.util.ArrayList;
import java.util.List;

import movie.review.service.Exceptions.MovieNotReleasedException;
import movie.review.service.Exceptions.MultipleReviewException;
import movie.review.service.domain.Movie;
import movie.review.service.domain.MovieReview;
import movie.review.service.domain.User;
import movie.review.service.services.MovieReviewService;
import movie.review.service.services.impl.MovieReviewServiceImpl;

/**
 * @author anoop
 *
 */
public class MovieReviewController {

	private MovieReviewService movieReviewService = new MovieReviewServiceImpl();

	public boolean addMovie(String movieName, int releaseYear, List<String> genre) {
		Movie movie=new Movie(movieName.toLowerCase(), releaseYear, new ArrayList<String>(genre));
		return movieReviewService.addMovie(movie);
	}

	public boolean addReview(String userName, String movieName, int rating) {
		MovieReview movieReview = new MovieReview(movieName.toLowerCase(), userName.toLowerCase(), rating);
		boolean status=false;
		try {
			status=movieReviewService.addReview(movieReview);
		} catch (MovieNotReleasedException e){
			System.out.println(e);
		} catch (MultipleReviewException e)  {
			System.out.println(e);
		} 
		return status;
	}

	public boolean addUser(String userName) {
		User user=new User(userName.toLowerCase());
		return movieReviewService.addUser(user);
	}

	public List<String> getTopMoviesByCritics(int n, String genre) {
		return movieReviewService.getTopMoviesByCritics(n, genre);
	}

	public double getAvgReviewScoreByYear(int year) {
		return movieReviewService.getAvgReviewScoreByYear(year);
	}

	public double getAvgReviewScoreMovie(String movieName) {
		return movieReviewService.getAvgReviewScoreMovie(movieName);
	}
}
