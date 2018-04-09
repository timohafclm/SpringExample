package example.controller;

import example.model.Application;

import example.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    ApplicationService service;

    @RequestMapping(value = "/last_application", method = RequestMethod.GET
                    ,headers = {"Accept=application/json,application/xml"}
                    ,produces = {"application/xml", "application/json"})
    public @ResponseBody Application lastApplication(@RequestParam(value = "id")String id) throws Exception{
            return service.getLastApplication(Integer.parseInt(id));
    }
}
