package ru.bellintegrator.practice.office;



import java.util.List;

public interface OfficeDao {
    /**
     * Получить все объекты Office
     *
     * @return
     */
    List<Office> all() ;
    /**
     * Получить Office по идентификатору id
     *
     * @param id
     * @return
     */

    Office loadById(Integer id) ;
    /**
     * Получить Office по идентификатору org_id
     *
     * @param org_id
     * @return
     */

    List<Office> loadByOrgId(Integer org_id);


    void save(Office office) ;

    void update(Office office) ;
}
