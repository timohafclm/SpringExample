package example.repository;

import example.model.Application;
import example.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, String> {
    Application findTopByContactIdOrderByDtCreatedDesc (Contact contact) throws Exception;
}
