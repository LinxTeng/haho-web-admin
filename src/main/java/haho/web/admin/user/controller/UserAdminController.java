package haho.web.admin.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import haho.web.admin.common.page.PageInfo;
import haho.web.admin.common.page.PageResult;
import haho.web.admin.user.dto.CustomerMemberDto;
import haho.web.admin.user.service.UserAdminService;

@Controller
public class UserAdminController {
    @Autowired
    UserAdminService userAdminService;

    @RequestMapping("/get/user")
    @ResponseBody
    PageResult<List<CustomerMemberDto>> home(CustomerMemberDto customerMemberDto, PageInfo page) {
        PageResult<List<CustomerMemberDto>> listUser = userAdminService.list(customerMemberDto, page);
        return listUser;
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }
}
