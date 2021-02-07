/**
 * 
 */
package movie.review.service.dao;

import java.util.List;

import movie.review.service.domain.MovieReview;

/**
 * @author anoop
 *
 */
public interface MovieReviewDAO {

	public boolean addReview(MovieReview movieReview);

	public List<MovieReview> getReviews();

	public boolean isReviewPresent(MovieReview movieReview);

}
