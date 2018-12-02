package com.criteria.project.application.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.criteria.project.application.domain.SearchCriteria;
import com.criteria.project.application.entity.User;
import com.criteria.project.application.helper.UserSearchQueryCriteriaConsumer;

@Repository
public class UserDAO implements IUserDAO {

	 @PersistenceContext
	 private EntityManager entityManager;

	public List<User> searchUser(List<SearchCriteria> params) {
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> query = builder.createQuery(User.class);
        final Root r = query.from(User.class);

        Predicate predicate = builder.conjunction();
        UserSearchQueryCriteriaConsumer searchConsumer = new UserSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
	}


	@Transactional
	public void save(User entity) {
		try {
			entityManager.persist(entity);
		} catch(PersistenceException pe) {
			throw pe;
		}
	}
}
