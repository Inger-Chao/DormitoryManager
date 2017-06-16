package model.user.abstarct;

/**
 * Created by Joki on 2017/6/7.
 */
public abstract class User {

    protected final String no;

    public User(String no) {
        this.no = no;
    }

    public String getNo() {
        return no;
    }
}
