package kodlamaio.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserDao;
import kodlamaio.northwind.core.etities.User;

@Service
public class UserManager implements UserService{
	
	UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public String add(User user) {
		this.userDao.save(user);
		return new String("Kullanıcı eklendi");
	}

	@Override
	public User findByEmail(String email) {
		return this.userDao.findByEmail(email);
	}

}
