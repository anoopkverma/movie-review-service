package movie.review.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import movie.review.service.dao.MovieReviewDAO;
import movie.review.service.domain.MovieReview;

public class MovieReviewDaoImpl implements MovieReviewDAO {
	private List<MovieReview> movieReviews = new ArrayList<MovieReview>();

	public boolean addReview(MovieReview movieReview) {
		boolean status = true;
		if (movieReviews.contains(movieReview))
			status = false;
		else
			movieReviews.add(movieReview);
		return status;
	}

	public List<MovieReview> getReviews() {
		return movieReviews;
	}

	public boolean isReviewPresent(MovieReview movieReview) {
		for (MovieReview review : movieReviews) {
			if (movieReview.equals(review))
				return true;
		}
		return false;
	}
}
