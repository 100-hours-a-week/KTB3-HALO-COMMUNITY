package springboot.kakao_boot_camp.domain.user.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import springboot.kakao_boot_camp.domain.user.entity.*;

import java.util.List;



@RequiredArgsConstructor
public class UserRepoCustomImpl implements UserRepoCustom {

    final private EntityManager entityManager;

    public List<User>  getUsers(){
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u", User.class
        );

        return query.getResultList();
    }


}
