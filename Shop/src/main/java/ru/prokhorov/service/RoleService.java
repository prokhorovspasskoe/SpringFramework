package ru.prokhorov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prokhorov.entities.Role;
import ru.prokhorov.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public RoleService() {
    }

    public List<Role> getAllRoles(){
        return (List<Role>) roleRepository.findAll();
    }
}
