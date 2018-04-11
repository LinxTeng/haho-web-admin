package haho.web.admin.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.PageResult;
import haho.web.admin.user.dao.CustomerMemberDao;
import haho.web.admin.user.dto.CustomerMemberDto;
import haho.web.admin.user.service.UserAdminService;

@Service
public class UserAdminServiceImpl implements UserAdminService {
    private static Logger logger = LoggerFactory.getLogger(UserAdminServiceImpl.class);

    @Autowired
    private CustomerMemberDao customerMemberDao;

    @Override
    public PageResult<List<CustomerMemberDto>> list(CustomerMemberDto customerDto, PageInfo page) {
        if (customerDto == null) {
            logger.warn("参数不能为空");
        }
        PageResult<List<CustomerMemberDto>> list = customerMemberDao.list(customerDto, page);
        return list;
    }
}
