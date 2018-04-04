package example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value="/last_application", method = RequestMethod.GET)
    public Application lastApplication(@RequestParam(value = "id")String id){
        JDBCLayer jdbc = new JDBCLayer();
        Application application = jdbc.lastApplication(Integer.parseInt(id)).get(0);
        return application;
    }

}
