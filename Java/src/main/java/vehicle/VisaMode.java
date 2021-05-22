package vehicle;

/**
 * @author Soufyan & Omar
 */
public class VisaMode extends TransactionMode{
    private User user;
    private String numberOfCard;
    private Integer ccv;

    public VisaMode(User user, String numberOfCard, Integer ccv) {
        this.user = user;
        this.numberOfCard = numberOfCard;
        this.ccv = ccv;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Double payment(Double price, EmailSender emailSender) {
        if(price <= 0){
            throw new IllegalArgumentException("The price must not be less than or equal to 0");
        }
        if(numberOfCard.equals("0000-2415-1104-9630") && ccv == 214){
            Email email = new Email(user,"Congratulations "+ this.user.getFirstname().toUpperCase() +" ! We hope you will put it to good use !\nVehicle purchase was successful\nTransaction mode : Visa\n\n");
            emailSender.pushEmail(email);
            return price;
        }
        throw new IllegalArgumentException("Incorrect data");
    }
}
