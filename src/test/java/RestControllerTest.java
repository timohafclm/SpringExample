import example.App;
import example.model.Application;
import example.model.Contact;
import example.repository.ApplicationRepository;
import example.repository.ContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class RestControllerTest {
    private MockMvc mockMvc;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    private List<Application> applicationList = new ArrayList<>();
    private Application lastApplication;

    private MediaType contentTypeJson = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MediaType contentTypeXml = new MediaType(MediaType.APPLICATION_XML.getType(),
            MediaType.APPLICATION_XML.getSubtype());

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        applicationList.add(new Application("test1", sdf.parse("2018-01-10 15:00"),"Black", new Contact(5)));
        applicationList.add(new Application("test2", sdf.parse("2017-05-08 20:00"),"Black", new Contact(5)));
        for(Application application : applicationList){
            this.contactRepository.save(application.getContactId());
            this.applicationRepository.save(application);
        }
        lastApplication = applicationList.get(0);
    }

    @Test
    public void applicationNotFound() throws Exception{
        mockMvc.perform(get("/last_application?id=10"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getJsonFormat() throws Exception{
        mockMvc.perform(get("/last_application?id=" + lastApplication.getContactId().getContactId())
                .header("Accept", contentTypeJson))
                .andExpect(content().contentType(contentTypeJson));
    }

    @Test
    public void getXmlFormat() throws Exception{
        mockMvc.perform(get("/last_application?id=" + lastApplication.getContactId().getContactId())
                .header("Accept", contentTypeXml))
                .andExpect(content().contentType(contentTypeXml));
    }

    @Test
    public void verifyLastApplication() throws Exception{
        mockMvc.perform(get("/last_application?id=" + lastApplication.getContactId().getContactId())
                .header("Content-Type", contentTypeJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentTypeJson))
                .andExpect(jsonPath("$.APPLICATION_ID", is(lastApplication.getApplicationId())));
    }

}