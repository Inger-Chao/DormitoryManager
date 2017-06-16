package util;

import model.user.abstarct.User;

/**
 * Created by Joki on 2017/6/7.
 */
public class UserService {

    public static final int TYPE_NONE = 0x00;
    public static final int TYPE_STUDENT = 0x01;
    public static final int TYPE_ADMIN = 0x02;
    public static final int TYPE_SUPERVISOR = 0x03;

    /**
     * 使用静态内部类来实现单例模式，避免同步带来的性能影响
     */
    private static final class UserServiceHolder{
        private static UserService sInstance = new UserService();
    }

    public static UserService getInstance(){
        return UserServiceHolder.sInstance;
    }

    public User currentUser; //当前登陆的用户

    private int userType = TYPE_NONE;

    public int getUserType(){
        return userType;
    }

    public void setUserType(int userType){
        this.userType = userType;
    }

    /**
     * 获取当前用户，返回一个账号
     * @return
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * 登陆：设置当前用户
     * @param currentUser
     */
    public void signIn(User currentUser) {
        this.currentUser = currentUser;
    }
}
