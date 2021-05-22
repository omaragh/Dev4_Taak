package vehicle;

import java.util.Objects;

/**
 * @author Soufyan & Omar
 */
public class User implements Observer{
    private String firstname;
    private String lastname;
    private String email;

    public User(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email);
    }

    @Override
    public void update(Subject subject) {
        subject.getEmails().forEach((email) -> {
            if(email.getReceiver().equals(this)){
                System.out.println("Connected as " + getFirstname() +" " + getLastname());
                System.out.println("Email received : \n" + email.getContent());
            }
        });
    }
}
