import java.io.Serializable;

public class User implements Serializable {

    private int user_id;
    private String user_fn;
    private String user_ln;
    private String user_un;
    private String user_pw;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_fn() {
        return user_fn;
    }

    public void setUser_fn(String user_fn) {
        this.user_fn = user_fn;
    }

    public String getUser_ln() {
        return user_ln;
    }

    public void setUser_ln(String user_ln) {
        this.user_ln = user_ln;
    }

    public String getUser_un() {
        return user_un;
    }

    public void setUser_un(String user_un) {
        this.user_un = user_un;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public User() {
        this.user_id = 0;
        this.user_fn = "";
        this.user_ln = "";
        this.user_un = "";
        this.user_pw = "";
    }

    public User(int user_id, String user_fn, String user_ln, String user_un, String user_pw) {
        this.user_id = user_id;
        this.user_fn = user_fn;
        this.user_ln = user_ln;
        this.user_un = user_un;
        this.user_pw = user_pw;
    }
}
