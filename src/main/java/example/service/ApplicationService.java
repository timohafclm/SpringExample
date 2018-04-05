package example.service;

import example.dao.JDBCLayer;
import example.exception.ApplicationNotFoundException;
import example.exception.DuplicateApplicationException;
import example.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    JDBCLayer jdbc;

    public Application getLastApplication(int contactId) throws Exception{
        List<Application> result = jdbc.lastApplication(contactId);
        if (result == null || result.size()==0) {
            throw new ApplicationNotFoundException();
        }
        if(result.size()==2 && result.get(0).getPRODUCT_NAME().equals(result.get(1).getPRODUCT_NAME())){
            throw new DuplicateApplicationException();
        }
        return result.get(0);
    }
}
