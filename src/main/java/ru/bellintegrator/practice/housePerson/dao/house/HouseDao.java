package ru.bellintegrator.practice.housePerson.dao.house;

import ru.bellintegrator.practice.housePerson.model.House;

import java.util.List;

/**
 * DAO для работы с House
 */
public interface HouseDao {
    /**
     * Получить все объекты House
     *
     * @return
     */
    List<House> all();

    /**
     * Получить House по идентификатору
     *
     * @param id
     * @return
     */
    House loadById(Long id);

    /**
     * Сохранить House
     *
     * @param house
     */
    void save(House house);
}
