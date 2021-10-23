package cn.anxcyun.www.control;

import java.util.List;

import cn.anxcyun.www.dao.UserDao;
import cn.anxcyun.www.po.User;

/**
 * 
    * @ClassName: Service
    * @Description: 
    * @author H&H
    * @date 
    *
 */
public class ServiceUser {
	
	UserDao userDao = new UserDao();
	/**
	 * 
	    * @Title: LoginUser
	    * @Description:
	    * @param @param user
	    * @param @return    
	    * @return boolean    
	    * @throws
	 */
	public boolean LoginUser(User user) {
		
		return  userDao.loginUser(user);
	}
	
	/**
	 * 
	    * @Title: InsertUser
	    * @Description: 
	    * @param @param user
	    * @param @return    
	    * @return boolean    
	    * @throws
	 */
	public boolean InsertUser(User user) {
		
		return  userDao.InsertUser(user);
	}
	
	/**
	 * 
	    * @Title: userList
	    * @Description: 
	    * @param @return    
	    * @return List<User>    
	    * @throws
	 */
	public List<User> userList(){
	
		return userDao.userList();
	}
	/**
	 * 
	    * @Title: updateUser
	    * @Description: 
	    * @param @param user
	    * @param @return    
	    * @return boolean    
	    * @throws
	 */
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	public boolean deleteUser(String name) {
		return userDao.deleteUser(name);
	}
	
	public User selectUser(String name) {
		return userDao.selectUser(name);
	}
	
	public List<User> select(String sql) {
		return userDao.select(sql);
	}
}
