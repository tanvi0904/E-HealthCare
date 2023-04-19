public class Room {
    private int RID;
    private int PID;
    private int NOB;

    public Room(int RID, int PID, int NOB) {
        this.RID = RID;
        this.PID = PID;
        this.NOB = NOB;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public int getNOB() {
        return NOB;
    }

    public void setNOB(int NOB) {
        this.NOB = NOB;
    }
}