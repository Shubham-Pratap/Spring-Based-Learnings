package com.criteria.project.application.repository;

import java.util.List;

import com.criteria.project.application.domain.SearchCriteria;
import com.criteria.project.application.entity.User;

public interface IUserDAO {
    List<User> searchUser(List<SearchCriteria> params);
    void save(User entity);
}