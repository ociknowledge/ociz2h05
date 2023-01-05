package com.oracle.lad.z2h.repository;

import java.util.List;
import com.oracle.lad.z2h.model.Person;

public interface PersonRepository {

    int create(final Person person);

    int update(final Person person);

    Person findById(final int id);

    int deleteById(final int id);

    List<Person> findAll();
}
