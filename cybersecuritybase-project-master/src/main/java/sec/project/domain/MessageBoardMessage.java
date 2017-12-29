package sec.project.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class MessageBoardMessage extends AbstractPersistable<Long> {

    private String subject;
    private String message;

    public MessageBoardMessage() {
        super();
    }

    public MessageBoardMessage(String subject, String message) {
        this();
        this.subject = subject;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String name) {
        this.subject = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
