public class User {
    private String id;
    private String name;
    private String age;
    private String bg;
    private String donation;

    public User(String id, String name, String age, String bg, String donation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bg = bg;
        this.donation = donation;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }

}
