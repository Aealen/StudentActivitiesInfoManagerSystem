package bean;

public class UsrAct {

    private String uid;
    private String actid;


    public UsrAct(String uid, String actid) {
        this.uid = uid;
        this.actid = actid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getActid() {
        return actid;
    }

    public void setActid(String actid) {
        this.actid = actid;
    }
}
