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

}
