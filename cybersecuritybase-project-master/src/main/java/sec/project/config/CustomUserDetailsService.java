package sec.project.config;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
        
    @Autowired
    private SignupRepository signupRepository;

    private Map<String, String> accountDetails;

    @PostConstruct
    public void init() {
        // this data would typically be retrieved from a database
        this.accountDetails = new TreeMap<>();

        // Add the default admin user and password
        this.accountDetails.put("admin", passwordEncoder.encode("changeme"));
        
        // Add the existing users
        this.accountDetails.put("satoshi", passwordEncoder.encode("secret"));
        this.accountDetails.put("roger", passwordEncoder.encode("carrots"));
        
        // Add the secret guest speaker
        Signup secretSignup = new Signup("satoshi", "Satoshi", "Secret");
        secretSignup.setIsSecret(true);
        this.signupRepository.save(secretSignup);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!this.accountDetails.containsKey(username)) {
            throw new UsernameNotFoundException("No such user: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                username,
                this.accountDetails.get(username),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
}
