package example.repository;

import example.model.Application;
import example.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, String> {
    List<Application> findTopByContactIdOrderByDtCreatedDesc (Contact contact) throws Exception;
}
