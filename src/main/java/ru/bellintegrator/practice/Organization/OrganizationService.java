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

    List<OrganizationView> organizations() throws SQLException;

    void saveOrganization(OrganizationView organizationView) throws SQLException ;

    void updateOrganization(OrganizationView organizationView) throws SQLException ;

    OrganizationView loadById(int id) throws SQLException ;

}