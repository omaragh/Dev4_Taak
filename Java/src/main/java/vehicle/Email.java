package vehicle;

public class Email {
    private String content;
    private User receiver;


    public Email(User receiver,  String content) {
        this.receiver = receiver;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }


}
