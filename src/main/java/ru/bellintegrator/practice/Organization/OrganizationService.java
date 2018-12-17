package ru.bellintegrator.practice.Organization;




import org.springframework.validation.annotation.Validated;

import java.sql.SQLException;
import java.util.List;
/**
 * Сервис
 */
@Validated
public interface OrganizationService {

    List<OrganizationView> organizations() throws SQLException;

    void saveOrganization(OrganizationView organization) throws SQLException ;

    void updateOrganization(OrganizationView organization) throws SQLException ;

    OrganizationView loadById(int id) throws SQLException ;

}