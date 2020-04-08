package com.quark.admin.service.impl;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.quark.admin.service.ReplyService;
import com.quark.common.base.BaseServiceImpl;
import com.quark.common.dao.ReplyDao;
import com.quark.common.entity.Posts;
import com.quark.common.entity.Reply;
import com.quark.common.entity.User;

/**
 * @Author LHR
 * Create By 2017/9/3
 */
@Service
public class ReplyServiceImpl extends BaseServiceImpl<ReplyDao,Reply> implements ReplyService {

    @Override
    public Page<Reply> findByPage(Reply reply, int pageNo, int length) {
        PageRequest pageable = PageRequest.of(pageNo, length);

        Specification<Posts> specification = new Specification<Posts>(){

            @Override
            public Predicate toPredicate(Root<Posts> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> $id = root.get("id");
                Path<String> $content = root.get("content");
                Path<User> $user = root.get("user");

                ArrayList<Predicate> list = new ArrayList<>();
                if (reply.getId()!=null) list.add(criteriaBuilder.equal($id,reply.getId()));
                if (reply.getContent()!=null) list.add(criteriaBuilder.like($content,"%" + reply.getContent() + "%"));
                if (reply.getUser()!=null) list.add(criteriaBuilder.equal($user,reply.getUser()));

                Predicate predicate = criteriaBuilder.and(list.toArray(new Predicate[list.size()]));

                return predicate;
            }
        };
        Page<Reply> page = repository.findAll(specification, pageable);
        return page;
    }
}
