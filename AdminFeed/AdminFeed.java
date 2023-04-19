public class AdminFeed {
    private int id;
    private String feeb;

    public AdminFeed(int id, String feeb) {
        this.id = id;
        this.feeb = feeb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeeb() {
        return feeb;
    }

    public void setFeeb(String feeb) {
        this.feeb = feeb;
    }

}