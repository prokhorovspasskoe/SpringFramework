package ru.prokhorov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.prokhorov.entities.Role;
import ru.prokhorov.service.RoleService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("")
    public String adminHome(Model model) {
        List<Role> rolesList = roleService.getAllRoles();
        model.addAttribute("rolesList", rolesList);
        return "admin-panel";
    }
}
