package example.dao;

import example.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JDBCLayer {
    @Autowired
    DataSource dataSource;

    private JdbcTemplate jdbcTemplate;
    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Application> lastApplication(int contactId) {
        final String QUERY_SQL =
                "SELECT * FROM APPLICATIONS WHERE DT_CREATED=(" +
                        "SELECT MAX(DT_CREATED) FROM APPLICATIONS WHERE CONTACT_ID=?)";
        List<Application> resultApplication = this.jdbcTemplate.query(QUERY_SQL, new Object[]{contactId}, new RowMapper<Application>(){
            @Override
            public Application mapRow(ResultSet resultSet, int i) throws SQLException {
                Application result = new Application();
                result.setAPPLICATION_ID(resultSet.getString("APPLICATION_ID"));
                result.setCONTACT_ID(resultSet.getInt("CONTACT_ID"));
                result.setDT_CREATED(resultSet.getDate("DT_CREATED"));
                result.setPRODUCT_NAME(resultSet.getString("PRODUCT_NAME"));
                return result;
            }
        });
        return resultApplication;
    }
}
