package vehicle;

public abstract class TransactionMode {
    protected final Double rate = 21.0;

    abstract Double payment(Double price, EmailSender emailSender);

    public Double getRate() {
        return rate;
    }

    public abstract User getUser();

    public Double applyTVA(Double priceHT){
        return ((rate+100)/100)*priceHT;
    }

}