package ru.bellintegrator.practice.Organization;




import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
/**
 * Сервис
 */
@Validated
public interface OrganizationService {
    /**
     * Получить список организаций
     *
     * @return {@Organization}
     */

    List<OrganizationView> organizations() ;


    void saveOrganization(OrganizationView organizationView) ;

    void updateOrganization(OrganizationView organizationView) ;
    /**
     * Получить организацию по id
     *
     * @return {@Organization}
     * @param id
     */
   OrganizationView loadById(Integer id) ;

}