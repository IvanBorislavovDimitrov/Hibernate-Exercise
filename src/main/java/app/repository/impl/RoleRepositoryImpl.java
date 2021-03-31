package app.repository.impl;

import app.entity.Role;
import app.repository.api.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;

@Repository
public class RoleRepositoryImpl extends AbstractRepository<Role> implements RoleRepository {

    @PostConstruct
    public void init() {
        if (!findAll().isEmpty()) {
            return;
        }
        Arrays.stream(Role.RoleType.values())
                .forEach(role -> {
                    Role r = new Role();
                    r.setRoleType(Role.RoleType.valueOf(role.name()));
                    save(r);
                });
    }

    @Override
    public Role findByRoleType(Role.RoleType roleType) {
        return executeInTransaction(entityManager -> {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
            Root<Role> root = criteriaQuery.from(Role.class);
            CriteriaQuery<Role> where = criteriaQuery.where(criteriaBuilder.equal(root.get("roleType"), roleType));
            TypedQuery<Role> query = entityManager.createQuery(where);
            return query.getSingleResult();
        });
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

}
