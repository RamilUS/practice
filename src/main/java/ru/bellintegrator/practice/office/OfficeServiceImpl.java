package ru.bellintegrator.practice.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.housePerson.model.mapper.MapperFacade;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao officeDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.mapperFacade= mapperFacade;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    @Transactional
    public List<OfficeView> offices()  {
        List<Office> all = officeDao.all();
        return mapperFacade.mapAsList(all,OfficeView.class);
    }
    /**
     * {@inheritDoc}
     */

    @Override
    @Transactional
    public void saveOffice(OfficeView view)  {
        Office office = new Office(view.id, view.org_id,view.name, view.address,view.phone, view.active);
        officeDao.save(office);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public OfficeView loadById(Integer id)  {
        Office loadById = officeDao.loadById(id);
        OfficeView offView = mapperFacade.map(loadById,OfficeView.class);
        return offView;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public List<OfficeView> loadByOrgId(Integer org_id)  {
        List<Office> loadByOrgId = officeDao.loadByOrgId(org_id);
        List<OfficeView> ListoffView = mapperFacade.mapAsList(loadByOrgId,OfficeView.class);
        return ListoffView;
    }


    /**
     * {@inheritDoc}
     */

    @Override
    public void updateOffice(OfficeView view){
        Office organization = new Office(view.id,view.org_id, view.name, view.address,view.phone,view.active);
        officeDao.update(organization);
    }
}
