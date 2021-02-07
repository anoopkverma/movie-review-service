/**
 * 
 */
package movie.review.service.domain;

/**
 * @author anoop
 *
 */
public class MovieReview {
	private String movieName;
	private String userName;
	private int rating;

	public MovieReview(String movieName, String userName, int rating) {
		super();
		this.movieName = movieName;
		this.userName = userName;
		this.rating = rating;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean equals(MovieReview obj) {
		// TODO Auto-generated method stub
		boolean status = true;
		if(!this.movieName.equalsIgnoreCase(obj.getMovieName()))
			status =false;
		if(!this.userName.equalsIgnoreCase(obj.getUserName()))
			status = false;
		return status;
	}
	
	

}
