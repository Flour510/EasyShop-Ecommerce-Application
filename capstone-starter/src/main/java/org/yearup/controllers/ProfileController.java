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

@RestController // add the annotation to make this a REST controller
@RequestMapping("/profile") // add the annotation to make this controller the endpoint for the following URL: http://localhost:8080/profile
@CrossOrigin // add annotation to allow cross-site origin requests
@PreAuthorize("isAuthenticated()") // add annotation to ensure that only authenticated users can access this controller
public class ProfileController {

    private ProfileDao profileDao;
    private UserDao userDao;

    // create an Autowired controller to inject the ProfileDao and UserDao
    @Autowired
    public ProfileController(ProfileDao profileDao, UserDao userDao) {
        this.profileDao = profileDao;
        this.userDao = userDao;
    }

    @GetMapping // add the appropriate annotation for a GET action
    public ResponseEntity<Profile> getProfile(Principal principal) {
        // get the username from the authenticated principal
        String userName = principal.getName();

        // find the user by username
        User user = userDao.getByUserName(userName);

        // get the user ID
        int userId = user.getId();

        // find the profile by user ID
        Profile profile = profileDao.getByUserId(userId);

        // if profile is not found, return a 404 not-found response
        if (profile == null) {
            return ResponseEntity.notFound().build();
        }

        // return the profile with a 200 OK response
        return ResponseEntity.ok(profile);
    }

    @PutMapping // add the appropriate annotation for a PUT (update) action
    public ResponseEntity<Profile> updateProfile(Principal principal, @RequestBody Profile profile) {
        // get the username from the authenticated principal
        String userName = principal.getName();

        // find the user by username
        User user = userDao.getByUserName(userName);

        // get the user ID
        int userId = user.getId();

        // set the user ID in the profile
        profile.setUserId(userId);

        // update the profile in the database
        profileDao.update(profile);

        // return the updated profile with a 200 OK response
        return ResponseEntity.ok(profile);
    }
}
