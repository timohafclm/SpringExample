package example.controller;

import example.model.Application;
import example.dao.JDBCLayer;
import example.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    ApplicationService service;

    @RequestMapping(value="/last_application", method = RequestMethod.GET)
    public Application lastApplication(@RequestParam(value = "id")String id) throws Exception{
        return service.getLastApplication(Integer.parseInt(id));
    }

}
