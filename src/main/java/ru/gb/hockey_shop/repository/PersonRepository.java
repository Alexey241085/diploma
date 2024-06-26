package ru.gb.hockey_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.hockey_shop.model.Person;

// репозиторий для класса Persoon
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


}
