package com.Tukki.TukkiPractice.repository;




import com.Tukki.TukkiPractice.models.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository {

    public List<UserEntity> getAllUser();

    public UserEntity getById(Long id);

    public void createUser(UserEntity user);

    public void deleteUser(Long id);

    public void modifyUser(UserEntity u);


}
