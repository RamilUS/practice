package ru.bellintegrator.practice.office;

import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Сервис
 */
@Validated
public interface OfficeService {
    /**
     * Получить список офисов
     *
     * @return {@Office}
     */

    List<OfficeView> offices() ;


    void saveOffice (OfficeView officeView) ;

    void updateOffice (OfficeView officeView) ;
    /**
     * Получить организацию по id
     *
     * @return {@Office}
     * @param id
     */
    OfficeView loadById(Integer id) ;

    /**
     * Получить организацию по org_id
     *
     * @return {@Office}
     * @param org_id
     */
    List<OfficeView> loadByOrgId(Integer org_id) ;

}
