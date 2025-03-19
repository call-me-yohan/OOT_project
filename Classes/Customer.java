package Classes;

public class Customer {
    private int custId;
    private String custName;
    private String paymentMethod;
    private String dob;
    private String phoneNumber;
    private String custAddress;

    public Customer(int custId, String custName, String paymentMethod, String dob, String phoneNumber, String custAddress){
        this.custId = custId;
        this.custName = custName;
        this.paymentMethod = paymentMethod;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.custAddress = custAddress;
    }
}
