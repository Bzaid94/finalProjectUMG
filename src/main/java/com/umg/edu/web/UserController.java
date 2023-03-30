package com.umg.edu.web;

import com.umg.edu.entity.User;
import com.umg.edu.manager.user.UserManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "${angular.url}", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    private UserManager userManager;

    @PostMapping("/newUser/")
    public User saveMessage(@RequestBody User message) {
        message.setStatus(true);
        return userManager.saveUser(message);
    }

    @PutMapping("/updateUser/{id}/")
    public User updateMessage(@RequestBody User message, @PathVariable("id") Long id) {
            return userManager.updateUser(message, id);
    }

    @PostMapping("/deleteUser/{id}/")
    public String deleteMessageById(@PathVariable("id") Long id){
        userManager.deleteUser(id);
        return "Message deleted successfully";
    }
}