package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        String hql = "SELECT u FROM User u WHERE u.id = :id";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setParameter("id", id);
        return (User) q.getSingleResult();
    }

    @Override
    public void deleteUserById(int id) {
        String hql = "DELETE FROM User WHERE id = :userId";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setParameter("userId", id);
        q.executeUpdate();
    }

    @Override
    public void updateUser(int id, User user) {
        String hql = "UPDATE User SET name = :name, height = :height, occupation = :occupation WHERE id = :userId";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setParameter("name", user.getName());
        q.setParameter("height", user.getHeight());
        q.setParameter("occupation", user.getOccupation());
        q.setParameter("userId", id);
        q.executeUpdate();
    }
}
