package com.Tukki.TukkiPractice.repository;


import com.Tukki.TukkiPractice.models.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserDAO implements UserRepository {

    @PersistenceContext
    EntityManager em;


    @Override
    public List getAllUser() {
        String query = "FROM UserEntity";
        return em.createQuery(query).getResultList();
    }

    @Override
    public UserEntity getById(Long id) {
        return em.find(UserEntity.class,id);
    }

    @Override
    public void createUser(UserEntity user) {
        em.persist(user);

    }

    @Override
    public void deleteUser(Long id) {
        em.remove(em.find(UserEntity.class,id));
    }

    @Override
    public void modifyUser(UserEntity u) {

        u.setName(u.getName());
        u.setLast_name(u.getLast_name());
        u.setAge(u.getAge());

        em.merge(u);
    }


}
