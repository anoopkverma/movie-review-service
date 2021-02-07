/**
 * 
 */
package Client;

import java.util.ArrayList;
import java.util.List;

import movie.review.service.controller.MovieReviewController;

/**
 * @author anoop
 *
 */
public class Client {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		MovieReviewController controller = new MovieReviewController();
		List<String> genre = new ArrayList<String>();

		// Add Movies

		genre.add("Action");
		genre.add("Comedy");
		controller.addMovie("DON", 2006, genre);
		genre.clear();

		genre.add("Drama");
		controller.addMovie("Tiger", 2008, genre);
		genre.clear();

		genre.add("Comedy");
		controller.addMovie("Padmaavat", 2006, genre);
		genre.clear();

		genre.add("Drama");
		controller.addMovie("Lunchbox", 2021, genre);
		genre.clear();

		genre.add("Drama");
		controller.addMovie("Guru", 2006, genre);
		genre.clear();

		genre.add("Romance");
		controller.addMovie("Metro", 2006, genre);
		genre.clear();

		// Add Users

		controller.addUser("SRK");
		controller.addUser("Salman");
		controller.addUser("Deepika");

		// Add Reviews
		controller.addReview("SRK", "DON", 2);
		controller.addReview("SRK", "Padmaavat", 8);
		controller.addReview("Salman", "DON", 5);
		controller.addReview("Deepika", "DON", 9);
		controller.addReview("Deepika", "Guru", 6);
		controller.addReview("SRK", "DON", 10);
		controller.addReview("SRK", "DON", 10);
		controller.addReview("Deepika", "Lunchbox", 4);
		controller.addReview("SRK", "Tiger", 5);
		controller.addReview("SRK", "Metro", 7);
		
		System.out.println();
		System.out.println();
		
		int number = 2;
		String selectedGenre = "Drama";
		System.out.println(
				"List top " + number + " movies by total review score by Reviewers in a genre " + selectedGenre);
		List<String> list = controller.getTopMoviesByCritics(number, "Drama");
		for (String movie : list) {
			System.out.print(movie + ", ");
		}
		System.out.println();
		System.out.println();

		int relYear = 2006;
		System.out.print("Average review score in release year- " + relYear + " : ");
		double result = (double) controller.getAvgReviewScoreByYear(relYear);
		System.out.println(result);
		System.out.println();

		String movName = "DON";
		System.out.print("Average review score for movie - " + movName + " : ");
		double res = (double) controller.getAvgReviewScoreMovie("DON");
		System.out.println(res);
	}
}
