package haho.web.admin.user.service;

import java.util.List;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.PageResult;
import haho.web.admin.user.dto.CustomerMemberDto;

public interface UserAdminService {
    /**
     * 查找用户
     */
    public PageResult<List<CustomerMemberDto>> listUser(CustomerMemberDto customerDto, PageInfo page);
}
