import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestBean {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void beanTest() {
        DataSource sampleBean = applicationContext.getBean("dataSource", DataSource.class);
        Assert.assertNotNull(sampleBean);
    }

}
