import example.App;
import example.model.Application;
import example.service.ApplicationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class TestJDBC {
    @Autowired
    private ApplicationService service;

    @Test
    public void lastApplicationTest1() throws Exception{
        Application application = service.getLastApplication(1);
        Assert.assertEquals("3jXnZLZXth", application.getAPPLICATION_ID());
    }

    @Test
    public void lastApplicationTest2() throws Exception{
        Application application = service.getLastApplication(2);
        Assert.assertEquals("iJNy8GiNSp", application.getAPPLICATION_ID());
    }
}
