package ru.bellintegrator.practice.user;

import org.springframework.validation.annotation.Validated;

import java.util.List;
/**
 * Сервис
 */
@Validated
public interface UserService {
    /**
     * Получить список пользователей
     *
     * @return List<UserView>
     */

    List<UserView> users() ;


    void saveUser(UserView userView) ;

    void updateUser(UserView userView) ;
    /**
     * Получить пользователя по id
     *
     * @return {@UserView}
     * @param id
     */
    UserView loadById(Integer id) ;
}
