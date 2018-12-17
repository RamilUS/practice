package ru.bellintegrator.practice.housePerson.service;

import ru.bellintegrator.practice.housePerson.view.PersonView;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.List;

/**
 * Сервис
 */
@Validated
public interface PersonService {

    /**
     * Добавить нового человека в БД
     *
     * @param person
     */
    void add(@Valid PersonView person);

    /**
     * Получить список людей
     *
     * @return {@Person}
     */
    List<PersonView> persons();
}
