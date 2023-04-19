
public class AdminPay {
    private String userID;
    private String paymentType;
    private String paymentAmount;
    private String paymentDate;
    private String transactionID;
    private String verify;

    public AdminPay(String userID, String paymentType, String paymentAmount, String paymentDate, String transactionID,
            String verify) {
        this.userID = userID;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.transactionID = transactionID;
        this.verify = verify;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}
