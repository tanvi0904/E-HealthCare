public class Appo{
    private String pid;
    private String did;
    private String date_time;
    private String Report;

    public Appo(String pid, String did, String date_time, String Report) {
        this.pid = pid;
        this.did = did;
        this.date_time = date_time;
        this.Report = Report;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getReport() {
        return Report;
    }

    public void setReport(String Report) {
        this.Report = Report;
    }

}
