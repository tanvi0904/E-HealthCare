public class Doctor {
    private String doctorID; 
    private String doctorName;
    private String doctorSp;

    public Doctor(String doctorID, String doctorName, String doctorSp) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.doctorSp = doctorSp;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getdoctorName() {
        return doctorName;
    }

    public String getDoctorSp() {
        return doctorSp;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public void setdoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDoctorSp(String doctorSp) {
        this.doctorSp = doctorSp;
    }

}
