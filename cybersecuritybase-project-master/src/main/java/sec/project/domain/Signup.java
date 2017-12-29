package sec.project.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Signup extends AbstractPersistable<Long> {

    private String username;
    private String name;
    private String address;
    private boolean isSecret = false;
    
    public Signup() {
        super();
    }

    public Signup(String username, String name, String address) {
        this();
        this.username = username;
        this.name = name;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public boolean getIsSecret() {
        return this.isSecret;
    }

    public void setIsSecret(boolean isSecret) {
        this.isSecret = isSecret;
    }
}
