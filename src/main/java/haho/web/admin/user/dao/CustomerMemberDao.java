package haho.web.admin.user.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import haho.web.admin.user.domain.CustomerMember;

public interface CustomerMemberDao extends CrudRepository<CustomerMember, Long> {

    /** 根据手机号查找用户 */
    Page<CustomerMember> findByMobile(String mobile, Pageable pageable);


}
