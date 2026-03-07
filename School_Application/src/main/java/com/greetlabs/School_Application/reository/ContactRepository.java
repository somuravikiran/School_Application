package com.greetlabs.School_Application.reository;

import com.greetlabs.School_Application.model.Contact;
import com.greetlabs.School_Application.rommappers.ContactMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer> {

    List<Contact> findByStatus(String status);

}
