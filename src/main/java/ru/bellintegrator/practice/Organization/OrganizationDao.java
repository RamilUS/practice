package ru.bellintegrator.practice.Organization;


import java.util.List;

public interface OrganizationDao {
    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> all() ;
    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */

    Organization loadById(Integer id) ;

    void save(Organization organization) ;

    void update(Organization organization) ;
}
