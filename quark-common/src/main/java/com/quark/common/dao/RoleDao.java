package com.quark.common.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quark.common.entity.Role;

/**
 * Created by lhr on 17-7-31.
 */

@Repository
@CacheConfig(cacheNames = "roles")
public interface RoleDao extends JpaRepository<Role,Integer>{

    Role getOne(Integer integer);

    @Cacheable
    List<Role> findAll();

}
