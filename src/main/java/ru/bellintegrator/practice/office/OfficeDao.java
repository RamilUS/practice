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
     * Получить Office по идентификатору org_id
     *
     * @param id
     * @return
     */

    Office loadById(Integer id) ;

    void save(Office office) ;

    void update(Office office) ;
}
