package ru.bellintegrator.practice.Organization;


import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.housePerson.model.mapper.MapperFacade;


import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */

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

    /**
     * {@inheritDoc}
     */

    @Override
    @Transactional
    public List<OrganizationView> organizations()  {
        List<Organization> all = organizationDao.all();
        return mapperFacade.mapAsList(all,OrganizationView.class);
    }
    /**
     * {@inheritDoc}
     */

    @Override
    @Transactional
    public void saveOrganization(OrganizationView view)  {
        Organization organization = new Organization(view.id,view.name, view.full_name, view.address,view.phone,view.inn,view.kpp,view.is_active);
        organizationDao.save(organization);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public OrganizationView loadById(Integer id)  {
        Organization loadById = organizationDao.loadById(id);
        OrganizationView orgView = mapperFacade.map(loadById,OrganizationView.class);
        return orgView;
    }

    /**
     * {@inheritDoc}
     */

   @Override
    public void updateOrganization(OrganizationView view){
       Organization organization = new Organization(view.id,view.name, view.full_name, view.address,view.phone,view.inn,view.kpp,view.is_active);
        organizationDao.update(organization);
    }
/*



    private Function<Organization, OrganizationView> mapOrganization() {
        return o -> {
            return organizationToViewList(o);
        };
    }*/


}
