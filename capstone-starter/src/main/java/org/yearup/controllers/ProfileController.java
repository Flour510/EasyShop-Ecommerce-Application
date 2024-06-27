// optional phase 4 controller
package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.ProfileDao;
import org.yearup.models.Profile;
import org.yearup.data.UserDao;
import org.yearup.models.User;

import java.security.Principal;

@RestController
@RequestMapping("/profile")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ProfileController {

    private ProfileDao profileDao;
    private UserDao userDao;

    @Autowired
    public ProfileController(ProfileDao profileDao, UserDao userDao) {
        this.profileDao = profileDao;
        this.userDao = userDao;
    }

    @GetMapping
    public ResponseEntity<Profile> getProfile(Principal principal) {
        String userName = principal.getName();
        User user = userDao.getByUserName(userName);
        int userId = user.getId();

        Profile profile = profileDao.getByUserId(userId);
        if (profile == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profile);
    }

    @PutMapping
    public ResponseEntity<Profile> updateProfile(Principal principal, @RequestBody Profile profile) {
        String userName = principal.getName();
        User user = userDao.getByUserName(userName);
        int userId = user.getId();
        profile.setUserId(userId);
        profileDao.update(profile);
        return ResponseEntity.ok(profile);
    }
}
