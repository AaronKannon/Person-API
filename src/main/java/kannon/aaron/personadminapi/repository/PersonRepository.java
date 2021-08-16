package kannon.aaron.personadminapi.repository;

import kannon.aaron.personadminapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
