package haho.web.admin.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.PageResult;
import haho.web.admin.user.dao.CustomerMemberDao;
import haho.web.admin.user.domain.CustomerMember;
import haho.web.admin.user.dto.CustomerMemberDto;
import haho.web.admin.user.service.UserAdminService;

@Service
public class UserAdminServiceImpl implements UserAdminService {
    @Autowired
    private CustomerMemberDao customerMemberDao;

    @Override
    public PageResult<List<CustomerMemberDto>> listUser(CustomerMemberDto customerDto, PageInfo page) {
        PageResult<List<CustomerMemberDto>> pageResult = PageResult.build();
        List<CustomerMemberDto> listResult = new ArrayList<>();

        pageResult.setPage(new PageInfo());
        // Page<CustomerMember> findAll = customerMemberDao.findAll(PageRequest.of(0, 10));
        Page<CustomerMember> findAll = customerMemberDao.findByMobile("19012340720", PageRequest.of(0, 10));
        List<CustomerMember> list = findAll.getContent();
        for (CustomerMember customerMember : findAll) {
            CustomerMemberDto customerMemberDto = new CustomerMemberDto();
            BeanUtils.copyProperties(customerMember, customerMemberDto);
            listResult.add(customerMemberDto);
        }
        pageResult.setResult(listResult);
        return pageResult;
    }

    @Override
    public PageResult<List<CustomerMemberDto>> findByMobile(CustomerMemberDto customerDto, PageInfo page) {
        Page<CustomerMember> findAll = customerMemberDao.findByMobile("15364155278", PageRequest.of(0, 10));
        return null;
    }

}
