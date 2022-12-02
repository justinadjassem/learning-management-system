package com.golfe3.LMS.services;

import com.golfe3.LMS.entities.AppRole;
import com.golfe3.LMS.entities.AppUser;

import java.util.List;

public interface AccountServices {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole( AppRole appRole);
    void asseignRoleToUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listOfUsers();
}
