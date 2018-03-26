package haho.web.admin.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haho.web.admin.common.page.PageResult;
import haho.web.admin.user.dto.CustomerMemberDto;
import haho.web.admin.user.service.UserAdminService;

@Controller
public class UserAdminController {
    @Autowired
    UserAdminService userAdminService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        PageResult<List<CustomerMemberDto>> listUser = userAdminService.listUser(null, null);
        return "" + listUser;
    }
}
