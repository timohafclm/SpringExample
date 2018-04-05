package example.controller;

import example.model.Application;
import example.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    ApplicationService service;

    @RequestMapping(value="/last_application_JSON", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Application lastApplicationJSON(@RequestParam(value = "id")String id) throws Exception{
            return service.getLastApplication(Integer.parseInt(id));

    }

    @RequestMapping(value="/last_application_XML", method = RequestMethod.GET, produces = "application/xml")
    public @ResponseBody Application lastApplicationXML(@RequestParam(value = "id")String id) throws Exception{
            return service.getLastApplication(Integer.parseInt(id));
    }

}
