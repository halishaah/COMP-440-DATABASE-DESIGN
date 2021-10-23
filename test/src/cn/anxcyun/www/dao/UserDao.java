package cn.anxcyun.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cn.anxcyun.www.po.User;
import cn.anxcyun.www.util.JDBConn;

public class UserDao {
	
//	login in 
	public boolean loginUser(User user) {
		
		boolean flag=false;// default false
		String sql= "select count(1) from User where u_username=? and u_password=?;";
		Connection conn =JDBConn.ConnJDBC();
		PreparedStatement prestatement = null ;
		
		try {
			//excute sql
			prestatement= conn.prepareStatement(sql);
			prestatement.setString(1, user.getU_name());
			prestatement.setString(2, user.getU_password());
			ResultSet rs = prestatement.executeQuery();
			//get first line
			while(rs.next()) {
				int result = rs.getInt(1);
				if(result>=1) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				//disconnect
				prestatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return flag;
	}
	
//	register
	public boolean InsertUser(User user) {
		boolean flag=false;//default
		String sql= "insert into User values(?,?,?,?,?);";
		Connection conn =JDBConn.ConnJDBC();
		PreparedStatement prestatement = null ;
		
		try {
			//sql
			prestatement= conn.prepareStatement(sql);
			prestatement.setString(1, user.getU_name());
			prestatement.setString(2, user.getU_password());
			prestatement.setString(3, user.getU_classes());
			prestatement.setString(4, user.getU_sex());
			prestatement.setString(5, user.getU_tel());
			
			//get which line was updated
			int count = prestatement.executeUpdate();
			if(count>=1) {
				flag =true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				//disconnect
				prestatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
//	get user info
	public boolean updateUser(User user) {
		
		boolean flag = false;
		Connection conn=JDBConn.ConnJDBC();
		String sql = "update user set u_username=?,u_password=?,u_class=?,u_sex=?,u_tel=? where u_username=?";
		PreparedStatement prestatement  =null;
		
		try {
			prestatement = conn.prepareStatement(sql);
			prestatement.setString(1, user.getU_name());
			prestatement.setString(2, user.getU_password());
			prestatement.setString(3, user.getU_classes());
			prestatement.setString(4, user.getU_sex());
			prestatement.setString(5, user.getU_tel());
			prestatement.setString(6, user.getU_name());
			
			int count = prestatement.executeUpdate();
			if(count >=1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				prestatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
//	user table
	public List<User> userList(){
		List<User> userlist = new LinkedList<User>();
		String sql= "select * from User;";
		Connection conn =JDBConn.ConnJDBC();
		PreparedStatement prestatement = null ;
		User user;
		
		try {
			prestatement = conn.prepareStatement(sql);
			ResultSet rs = prestatement.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setU_name(rs.getString(1));
				user.setU_password(rs.getString(2));
				user.setU_classes(rs.getString(3));
				user.setU_sex(rs.getString(4));
				user.setU_tel(rs.getString(5));
				userlist.add(user);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userlist;
	}
	
//	delete user info
	public boolean deleteUser(String name) {
		boolean flag = false;
		Connection conn=JDBConn.ConnJDBC();
		String sql = "delete from user where u_username=? ";
		PreparedStatement prestatement  =null;
		
		try {
			prestatement = conn.prepareStatement(sql);
			prestatement.setString(1, name);

			int count = prestatement.executeUpdate();
			if(count >=1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				prestatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
//	Select user info
	public User selectUser(String name) {
		
		User user = new User();
		String sql= "select * from User where u_username=?;";
		Connection conn =JDBConn.ConnJDBC();
		PreparedStatement prestatement = null ;
		try {
			prestatement = conn.prepareStatement(sql);
			prestatement.setString(1, name);
			ResultSet rs = prestatement.executeQuery();
			while(rs.next()) {
				user.setU_name(rs.getString(1));
				user.setU_password(rs.getString(2));
				user.setU_classes(rs.getString(3));
				user.setU_sex(rs.getString(4));
				user.setU_tel(rs.getString(5));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

//	other select (like%)
	public List<User> select(String sql) {
		List<User> userlist = new LinkedList<User>();
		Connection conn =JDBConn.ConnJDBC();
		PreparedStatement prestatement = null ;
		User user;
		
		try {
			prestatement = conn.prepareStatement("select * from user "+sql);
			System.out.println("select * from user"+sql);
			ResultSet rs = prestatement.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setU_name(rs.getString(1));
				user.setU_password(rs.getString(2));
				user.setU_classes(rs.getString(3));
				user.setU_sex(rs.getString(4));
				user.setU_tel(rs.getString(5));
				userlist.add(user);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userlist;
	}
	
}
