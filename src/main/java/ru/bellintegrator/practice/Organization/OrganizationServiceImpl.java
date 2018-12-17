package ru.bellintegrator.practice.Organization;


import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.housePerson.model.mapper.MapperFacade;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    //private final Logger log = LoggerFactory.getLogger(getClass());
    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade= mapperFacade;
    }

    @Override
    @Transactional
    public List<OrganizationView> organizations() throws SQLException {
        List<Organization> all = organizationDao.all();
        return mapperFacade.mapAsList(all,OrganizationView.class);
    }

    @Override
    @Transactional
    public void saveOrganization(OrganizationView view) throws SQLException {
        Organization organization = new Organization(view.id,view.name, view.fullName, view.address,view.phone,view.inn,view.kpp,view.isActive);
        organizationDao.save(organization);
    }
    @Override
    public OrganizationView loadById(int id) throws SQLException {
        Organization loadById = organizationDao.loadById(id);
        return mapperFacade.map(loadById,OrganizationView.class);
    }

   @Override
    public void updateOrganization(OrganizationView view) throws SQLException {
       Organization organization = new Organization(view.id,view.name, view.fullName, view.address,view.phone,view.inn,view.kpp,view.isActive);
        organizationDao.update(organization);
    }
/*



    private Function<Organization, OrganizationView> mapOrganization() {
        return o -> {
            return organizationToViewList(o);
        };
    }*/


}
