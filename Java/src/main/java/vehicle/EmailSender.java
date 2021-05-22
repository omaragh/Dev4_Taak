package vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Soufyan & Omar
 */
public class EmailSender implements Subject{
    private List<Email> emails;
    private List<Observer> observers;

    public EmailSender() {
        this.emails = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public void pushEmail(Email email){
        System.out.println("***********************");
        this.emails.add(email);
        this.notifyUpdates();
    }


    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void register(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void unregister(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyUpdates() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

    @Override
    public List<Email> getEmails() {
        return emails;
    }
}
