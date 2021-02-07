/**
 * 
 */
package movie.review.service.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.ExceptionList;

import movie.review.service.dao.impl.MovieDaoImpl;
import movie.review.service.dao.impl.MovieReviewDaoImpl;
import movie.review.service.dao.impl.UserDaoImpl;
import movie.review.service.Exceptions.MovieNotReleasedException;
import movie.review.service.Exceptions.MultipleReviewException;
import movie.review.service.dao.*;
import movie.review.service.domain.Movie;
import movie.review.service.domain.MovieReview;
import movie.review.service.domain.User;

/**
 * @author anoop
 *
 */

import movie.review.service.services.MovieReviewService;;

public class MovieReviewServiceImpl implements MovieReviewService {

	private static MovieDAO movieDao = new MovieDaoImpl();
	private static UserDAO userDAO = new UserDaoImpl();
	private static MovieReviewDAO movieReviewDAO = new MovieReviewDaoImpl();

	public boolean addMovie(Movie movie) {
		return movieDao.addMovie(movie);
	}

	public boolean addReview(MovieReview movieReview) throws MultipleReviewException, MovieNotReleasedException {
		boolean movieReleaseStatus = isMovieReleased(movieReview.getMovieName(), 2020);
		if(!movieReleaseStatus) {
			throw new MovieNotReleasedException("Movie- "+movieReview.getMovieName()+" is yet to be Released.");
		}
		boolean presentStatus = movieReviewDAO.isReviewPresent(movieReview);
		//System.out.println(movieReview.getMovieName() + " " + presentStatus);
		boolean status = false;
		if (presentStatus) {
			throw new MultipleReviewException("Multiple Reviews not allowed. Review by " + movieReview.getUserName() + " for Movie-"
					+ movieReview.getMovieName() + " is already present");
		} else {
			status = movieReviewDAO.addReview(movieReview);
		}
		return status;
	}

	private boolean isMovieReleased(String movieName, int currentYear) {
		// TODO Auto-generated method stub
		Movie movie = movieDao.getMovieByName(movieName);
		if(movie == null)
			return false;
		if(movie.getReleaseYear()> currentYear)
			return false;
		return true;
	}

	public boolean addUser(User user) {
		return userDAO.addUser(user);
	}

	public List<String> getTopMoviesByCritics(int n, String genre) {
		List<MovieReview> movieReviews = movieReviewDAO.getReviews();
		List<Movie> movies = movieDao.getAllMovies();
		Map<String, Movie> map = new HashMap<String, Movie>();
		for (Movie movie : movies) {
			map.put(movie.getMovieName(), movie);
		}

		List<MovieReview> list = new ArrayList<MovieReview>();
		for (MovieReview review : movieReviews) {
			Movie movie = map.get(review.getMovieName());
			if (movie.getGenre().contains(genre))
				list.add(review);
		}

		Map<String, Integer> movieScore = new HashMap<String, Integer>();
		for (MovieReview review : movieReviews) {
			Movie movie = map.get(review.getMovieName());
			if (movie.getGenre().contains(genre))
				movieScore.put(movie.getMovieName(),
						movieScore.getOrDefault(movie.getMovieName(), 0) + review.getRating());
		}
		List<String> result = new ArrayList<String>(movieScore.keySet());
		Collections.sort(result, (a, b) -> (movieScore.get(a) < movieScore.get(b)) ? 1 : -1);
		List<String> finalResult;
		if (result.size() > n)
			finalResult = new ArrayList<String>(result.subList(0, n));
		else
			finalResult = new ArrayList<String>(result);
		return finalResult;
	}

	public double getAvgReviewScoreByYear(int year) {
		List<MovieReview> movieReviews = movieReviewDAO.getReviews();
		List<Movie> movies = movieDao.getAllMovies();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Movie movie : movies) {
			map.put(movie.getMovieName(), movie.getReleaseYear());
		}

		double score = 0;
		int count = 0;
		for (MovieReview mr : movieReviews) {
			if (map.containsKey(mr.getMovieName()) && map.get(mr.getMovieName()) == year) {
				score += (double) mr.getRating();
				count++;
			}
		}
		double result = score / count;
		return result;
	}

	public double getAvgReviewScoreMovie(String movieName) {
		List<MovieReview> movieReviews = movieReviewDAO.getReviews();
		double score = 0;
		int count = 0;
		for (MovieReview mr : movieReviews) {
			if (mr.getMovieName().equalsIgnoreCase(movieName)) {
				score += mr.getRating();
				count++;
			}
		}
		double result = score / count;
		return result;
	}

}
