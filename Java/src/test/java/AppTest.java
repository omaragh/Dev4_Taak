import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehicle.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Soufyan & Omar
 */
public class AppTest {

    Vehicle bmw, mercedes,audi;
    VehicleFactory vehicleFactory;
    Payment payment;
    User user1, user2;
    EmailSender emailSender;

    @BeforeEach
    public void setUp(){
        emailSender = new EmailSender();
        user1 = new User("Jean", "Dupont","jean.dupont@hotmail.be");
        user2 = new User("Albert", "Einstein", "albert.einstein@gmail.be");
        payment = new Payment();
        vehicleFactory = new VehicleFactory();
        this.audi = vehicleFactory.createVehicle(VehicleEnum.AUDI);
        this.mercedes = vehicleFactory.createVehicle(VehicleEnum.MERCEDES);
        this.bmw = vehicleFactory.createVehicle(VehicleEnum.BMW);
    }


    @Test
    public void createVehicleTestWithPatternFactoryMethod(){
        assertEquals("BMW", bmw.getBrand());
        assertEquals(19000d, bmw.getPrice());
        assertEquals("Mercedes", mercedes.getBrand());
        assertEquals(72500d, mercedes.getPrice());
        assertEquals("Audi", audi.getBrand());
        assertEquals(25000d,audi.getPrice());
    }

    @Test
    public void createVehicleTestWithError(){
        assertThrows(IllegalArgumentException.class, () -> vehicleFactory.createVehicle(null));
    }


    @Test
    public void processPaymentViaCheckWhenBuyingMercedes(){
        //Before TVA
        assertEquals(72500d, mercedes.getPrice());
        //After purchase, TVA is applied
        TransactionMode checkMode = new CheckMode(user1,true);
        assertEquals(87725.0d,payment.process(checkMode,mercedes,emailSender));
    }

    @Test
    public void processPaymentViaVisaWhenBuyingAudi(){
        //Before TVA
        assertEquals(25000d, audi.getPrice());
        //After purchase, TVA is applied
        TransactionMode visaMode = new VisaMode(user1,"0000-2415-1104-9630",214);
        assertEquals(30250d,payment.process(visaMode,audi,emailSender));
    }


    @Test
    public void processPaymentViaCheckWhenBuyingBmwWithErrorSignatureFalse(){
        assertThrows(IllegalArgumentException.class, () -> {
            TransactionMode checkMode = new CheckMode(user2, false);
            payment.process(checkMode,bmw,emailSender);
        });
    }

    @Test
    public void processPaymentViaVisaWhenBuyingBmwWithErrorNumberOfCardAndCCV(){

        assertThrows(IllegalArgumentException.class, () -> {
            TransactionMode visaMode = new VisaMode(user2,"0000-2415-1104-1111",888);
            payment.process(visaMode,bmw,emailSender);
        });
    }


    @Test
    public void completeTestWithBuyingVehicleAndNotifyUsers(){
        emailSender.register(user1);
        emailSender.register(user2);
        TransactionMode checkMode = new CheckMode(user1,true);
        TransactionMode visaMode = new VisaMode(user2,"0000-2415-1104-9630",214);
        assertEquals(22990.0d,payment.process(checkMode, bmw, emailSender));
        assertEquals(87725.0d,payment.process(visaMode, mercedes, emailSender));
        assertEquals(2,emailSender.getObservers().size());
        assertEquals(2,emailSender.getEmails().size());
    }


}
