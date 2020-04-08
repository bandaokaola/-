package com.quark.common.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.quark.common.entity.AdminUser;

/**
 * Created by lhr on 17-7-31.
 */
@Repository
@CacheConfig(cacheNames = "adminusers")
public interface AdminUserDao extends JpaRepository<AdminUser,Integer>,JpaSpecificationExecutor {

    AdminUser getOne(Integer integer);

    @Cacheable
    List<AdminUser> findAll();

    AdminUser findByUsername(String username);

    @Cacheable
    @Override
    List findAll(Specification specification, Sort sort);
}
