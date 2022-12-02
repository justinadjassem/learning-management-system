package com.golfe3.LMS.services;

import com.golfe3.LMS.entities.AppRole;
import com.golfe3.LMS.entities.AppUser;
import com.golfe3.LMS.repositories.AppRoleRepository;
import com.golfe3.LMS.repositories.AppUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServicesImpl implements AccountServices {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    public AccountServicesImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {

        return appRoleRepository.save(appRole);
    }

    @Override
    public void asseignRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);

    }

    @Override
    public AppUser loadUserByUsername(String username) {

        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listOfUsers() {

        return appUserRepository.findAll();
    }
}
