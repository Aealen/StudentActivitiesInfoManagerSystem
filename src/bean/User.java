package bean;

public class User {

    private String id;
    private String name;
    private String pwd;
    private String isAdmin;
    private String last_login;


    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String id, String name, String pwd, String isAdmin) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.isAdmin = isAdmin;
    }

    public User(String id, String name, String pwd, String isAdmin, String last_login) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.isAdmin = isAdmin;
        this.last_login = last_login;
    }

    public User(String id, String name, String isAdmin) {
        this.id = id;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    @Override
    public String toString(){
        return "User{"+"id="+id+",name="+name+".pwd="+pwd+",isAdmin="+isAdmin+".Last_login="+last_login+'}';
    }
}
