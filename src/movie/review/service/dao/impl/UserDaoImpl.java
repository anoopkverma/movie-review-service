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

import movie.review.service.dao.UserDAO;
import movie.review.service.domain.*;

public class UserDaoImpl implements UserDAO {
	private List<User> users = new ArrayList<User>();

	public boolean addUser(User user) {
		boolean status = true;
		if (users.contains(user))
			status = false;
		else
			users.add(user);
		return status;
	}
}
