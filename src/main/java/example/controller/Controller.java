package example.controller;

import example.model.Application;

import example.model.ResponseTransfer;
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
    @ResponseBody
    public ResponseTransfer lastApplication(@RequestParam(value = "id")String id) throws Exception{
            Application application = service.getLastApplication(Integer.parseInt(id));
            return new ResponseTransfer(application.getApplicationId()
                                        ,application.getContactId().getContactId()
                                        ,application.getDtCreated()
                                        ,application.getProductName());
    }

}
