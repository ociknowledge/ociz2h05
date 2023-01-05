package com.oracle.lad.z2h.repository;

import java.util.List;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.oracle.lad.z2h.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPersonRepository implements PersonRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(final Person person) {
        return this.jdbcTemplate.update("INSERT INTO ZTH.PERSONS (NAME, EMAIL, ROLENAME, PHONE, COUNTRYCODE) VALUES(?,?,?,?,?)", new Object[]{person.getName(), person.getEmail(), person.getRoleName(), person.getPhone(), person.getCountryCode()});
    }

    @Override
    public int update(final Person person) {
        return this.jdbcTemplate.update("UPDATE ZTH.PERSONS SET NAME = ?, EMAIL = ?, ROLENAME = ?, PHONE = ?, COUNTRYCODE = ? WHERE ID = ?", new Object[]{person.getName(), person.getEmail(), person.getRoleName(), person.getPhone(), person.getCountryCode(), person.getId()});
    }

    @Override
    public Person findById(final int id) {
        try {
            final Person person = (Person) this.jdbcTemplate.queryForObject("SELECT ID, NAME, EMAIL, ROLENAME, PHONE, COUNTRYCODE FROM ZTH.PERSONS WHERE ID = ?", (RowMapper) BeanPropertyRowMapper.newInstance((Class) Person.class), new Object[]{id});
            return person;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(final int id) {
        return this.jdbcTemplate.update("DELETE FROM ZTH.PERSONS WHERE ID = ?", new Object[]{id});
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) this.jdbcTemplate.query("SELECT ID, NAME, EMAIL, ROLENAME, PHONE, COUNTRYCODE FROM ZTH.PERSONS", (RowMapper) BeanPropertyRowMapper.newInstance((Class) Person.class));
    }
}
