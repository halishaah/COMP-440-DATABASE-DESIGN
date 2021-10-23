package cn.anxcyun.www.po;


    /**
    * @ClassName: User
    * @Description: TODO
    * @author H&H
    * @date 
    *
    */
    
public class User {
	
	protected String u_name;
	protected String u_password;
	protected String u_classes;
	protected String u_sex;
	protected String u_tel;
	
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_classes() {
		return u_classes;
	}
	public void setU_classes(String u_classes) {
		this.u_classes = u_classes;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_tel() {
		return u_tel;
	}
	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}
	@Override
	public String toString() {
		return "User [u_name=" + u_name + ", u_password=" + u_password + ", u_classes=" + u_classes  + ", u_sex=" + u_sex
				+ ", u_tel=" + u_tel + "]";
	}
	public User(String u_name, String u_password, String u_classes, String u_sex, String u_tel) {
		super();
		this.u_name = u_name;
		this.u_classes = u_classes;
		this.u_password = u_password;
		this.u_sex = u_sex;
		this.u_tel = u_tel;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
