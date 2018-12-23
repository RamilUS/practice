package ru.bellintegrator.practice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.housePerson.model.mapper.MapperFacade;

import java.util.List;

/**
 * {@inheritDoc}
 */

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao userDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.mapperFacade= mapperFacade;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    @Transactional
    public List<UserView> users()  {
        List<User> all = userDao.all();
        return mapperFacade.mapAsList(all,UserView.class);
    }
    /**
     * {@inheritDoc}
     */

    @Override
    @Transactional
    public void saveUser(UserView view)  {
        User user = new User(view.id,view.office_id, view.first_name, view.last_name,view.second_name, view.middle_name, view.position,view.phone, view.doc_id, view.citizenship_id,view.is_identified);
        userDao.save(user);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public UserView loadById(Integer id)  {
        User loadById = userDao.loadById(id);
        UserView userView = mapperFacade.map(loadById,UserView.class);
        return userView;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void updateUser(UserView view){
        User user = new User(view.id,view.office_id, view.first_name, view.last_name,view.second_name, view.middle_name, view.position,view.phone, view.doc_id, view.citizenship_id,view.is_identified);
        userDao.update(user);
    }
}
