package example.service;

import example.model.Contact;
import example.repository.ApplicationRepository;
import example.exception.ApplicationNotFoundException;
import example.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    public Application getLastApplication(Integer contactId) throws Exception{
        Application result = applicationRepository.findTopByContactIdOrderByDtCreatedDesc(new Contact(contactId));
        if (result == null ) {
            throw new ApplicationNotFoundException();
        }
        return result;
    }
}