package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.etities.User;

public interface UserService {
	String add(User User);
	
	User findByEmail(String email);
}
