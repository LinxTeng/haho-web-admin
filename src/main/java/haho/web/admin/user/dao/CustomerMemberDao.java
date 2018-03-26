package haho.web.admin.user.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import haho.web.admin.user.domain.CustomerMember;

public interface CustomerMemberDao extends Repository<CustomerMember, Long> {
    Page<CustomerMember> findAll(Pageable pageable);
}
