package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser , HttpStatus.CREATED);
    }

    @PostMapping("/signIn")
    public ResponseEntity<String> login(@RequestParam String username , @RequestParam String passsword){
        boolean isAuthenticated = userService.authenticate(username , passsword);
        if(isAuthenticated){
            return ResponseEntity.ok("Login Successful");
        }else{
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or password");
        }
    }


}
