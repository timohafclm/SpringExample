package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    JDBCLayer jdbc;

    @RequestMapping(value="/last_application", method = RequestMethod.GET)
    public Application lastApplication(@RequestParam(value = "id")String id){
        Application application = jdbc.lastApplication(Integer.parseInt(id)).get(0);
        return application;
    }

}
