package vehicle;


import java.util.List;

public interface Subject {
    void register(Observer ob);
    void unregister(Observer ob);
    void notifyUpdates();


    List<Email> getEmails();
    void pushEmail(Email email);
}
