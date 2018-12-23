package ru.bellintegrator.practice.user;

import java.util.List;

/**
 * DAO для работы с User
 */
public interface UserDao {
    /**
     * Получить employee по фильтру
     *
     *
     * @return List<User>
     */
    List<User> all() ;

    /**
     * Получить Employee по идентификатору
     *
     * @param id
     * @return Employee
     */
    User loadById(Integer id);

    /**
     * Сохранить User
     *
     * @param user
     */
    void save(User user);

    /**
     *Обновить User
     *
     * @param user
     */
    void update(User user);
}
