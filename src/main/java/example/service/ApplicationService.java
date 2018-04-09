package example.service;

import example.model.Contact;
import example.repository.ApplicationRepository;
import example.exception.ApplicationNotFoundException;
import example.exception.DuplicateApplicationException;
import example.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    public Application getLastApplication(Integer contactId) throws Exception{
        List<Application> result = applicationRepository.findTopByContactIdOrderByDtCreatedDesc(new Contact(contactId));
        if (result == null || result.size()==0) {
            throw new ApplicationNotFoundException();
        }
        if(result.size()==2 && result.get(0).getProductName().equals(result.get(1).getProductName())){
            throw new DuplicateApplicationException();
        }
        return result.get(0);
    }
}