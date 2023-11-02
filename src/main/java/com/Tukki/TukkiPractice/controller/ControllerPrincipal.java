package com.Tukki.TukkiPractice.controller;


import com.Tukki.TukkiPractice.models.UserEntity;
import com.Tukki.TukkiPractice.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ControllerPrincipal {

   @Autowired
    private UserDAO userDAO;

   @GetMapping
    public List<UserEntity> getAllUsers(){
       return userDAO.getAllUser();
   }

   @GetMapping("/{id}")
    public UserEntity getById(@PathVariable("id") Long id){
       return userDAO.getById(id);
   }

   @PostMapping
    public String createUser(@RequestBody UserEntity u){
       userDAO.createUser(u);

       return "Usuario creado exitosamente!";
   }

   @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
       userDAO.deleteUser(id);

       return "Usuario eliminado exitosamente";
   }

   @PutMapping("/{id}")
    public ResponseEntity<UserEntity> modifyUser(@PathVariable Long id, @RequestBody UserEntity u){
       UserEntity newUser = userDAO.getById(id);

       if(newUser == null){
           return ResponseEntity.notFound().build();
       }else{
           u.setId(newUser.getId());
           userDAO.modifyUser(u);

           return ResponseEntity.ok(u);
       }
   }
}
