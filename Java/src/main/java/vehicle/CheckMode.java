package vehicle;


public class CheckMode extends TransactionMode{
    private User user;
    private boolean signature;

    public CheckMode(User user, boolean signature) {
        this.user = user;
        this.signature = signature;
    }

    public boolean isSignature() {
        return signature;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Double payment(Double price, EmailSender emailSender) {
        if(price <= 0){
            throw new IllegalArgumentException("The price must not be less than or equal to 0");
        }
        if(signature){
            Email email = new Email(user,"Congratulations "+ this.user.getFirstname().toUpperCase() +" ! We hope you will put it to good use !\nVehicle purchase was successful\nTransaction mode : Check\n\n");
            emailSender.pushEmail(email);
            return price;
        }
        throw new IllegalArgumentException("Incorrect data");
    }
}
