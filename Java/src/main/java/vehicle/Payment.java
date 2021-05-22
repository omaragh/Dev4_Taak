package vehicle;

/**
 * @author Soufyan & Omar
 */
public class Payment {
    public Double process(TransactionMode transactionMode ,Vehicle vehicle, EmailSender emailSender){
        Double priceTTC = transactionMode.applyTVA(vehicle.getPrice());
        return transactionMode.payment(priceTTC, emailSender);
    }
}
