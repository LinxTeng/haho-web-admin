package haho.web.admin.user.service;

import java.util.List;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.PageResult;
import haho.web.admin.user.dto.CustomerMemberDto;

public interface UserAdminService {
    /**
     * 查找会员
     *
     * @param customerDto
     * @param page
     * @return
     * @date 2018年3月27日
     * @author linxTeng
     */
    public PageResult<List<CustomerMemberDto>> list(CustomerMemberDto customerDto, PageInfo page);
}
