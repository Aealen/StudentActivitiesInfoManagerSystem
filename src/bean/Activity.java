package bean;

public class Activity {

    private String id;
    private String name;
    private String desc;
    private String status;
    private String currentNum;//当前人数
    private String maxNum;//最大人数
    private String time;

    public Activity() {
    }

    public Activity(String id, String name, String desc, String status, String currentNum, String maxNum, String time) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.status = status;
        this.currentNum = currentNum;
        this.maxNum = maxNum;
        this.time = time;
    }

    public Activity(String name) {
        this.name = name;//赋值一次
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(String currentNum) {
        this.currentNum = currentNum;
    }

    public String getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(String maxNum) {
        this.maxNum = maxNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
