package springboot.kakao_boot_camp.repository.user;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import springboot.kakao_boot_camp.entity.User;

import java.util.List;



@RequiredArgsConstructor
public class UserRepoImpl implements UserRepoCustom {

    final private EntityManager entityManager;

    public List<User>  getUsers(){
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u", User.class
        );

        return query.getResultList();
    }


}
