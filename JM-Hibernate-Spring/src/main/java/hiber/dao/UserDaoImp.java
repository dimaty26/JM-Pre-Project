package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User findByCar(String model, int series) throws SQLException {

      Query query = sessionFactory.getCurrentSession().createQuery("from User where car.model = :model AND car.series = :series");
      query.setParameter("model", model);
      query.setParameter("series", series);

      User user;

      try {
         user = (User) query.getResultList().get(0);
      } catch (Exception e) {
         throw new SQLException("There is no User with Car model: " + model + " and Car series: " + series);
      }

      return user;
   }

}
