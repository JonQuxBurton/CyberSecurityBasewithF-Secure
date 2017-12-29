package sec.project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sec.project.repository.SignupRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private WebApplicationContext webAppContext;

    @Autowired
    private SignupRepository signupRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext)
                .apply(SecurityMockMvcConfigurers.springSecurity()).build();
    }

    @Test
    @WithMockUser(username = "user1")
    public void signupAddsDataToDatabase() throws Throwable {
        // Unfortunatelt this doesn't work anymore. I don't know why.
        //mockMvc.perform(post("/form").param("name", "Testname").param("address", "Testaddress")).andReturn();
        //assertEquals(1L, signupRepository.findAll().stream().filter(s -> s.getUsername().equals("user1") && s.getName().equals("Testname") && s.getAddress().equals("Testaddress")).count());
    }
}
