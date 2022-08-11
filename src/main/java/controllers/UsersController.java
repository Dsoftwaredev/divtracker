package controllers;


import entities.Stocks;
import entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import repositories.StocksRepository;
import repositories.UsersRepository;

import java.util.List;
import java.util.Optional;


@RestController
public class UsersController {


    private final UsersRepository usersRepository;
    @Autowired
    public UsersController( UsersRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return this.usersRepository.findAll();
    }


    @GetMapping("/users/{id}")
    public Optional<Users> getUserById(@PathVariable("id") Integer id) {
        return this.usersRepository.findById(id);
    }
    @PostMapping("/users")
    public Users createNewUser(@RequestBody Users users) {
        Users newUser = usersRepository.save(users);
        return newUser;
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users updateUser(@PathVariable("id") Integer id, @RequestBody Users users) {
        Optional<Users> userToUpdateOptional = this.usersRepository.findById(id);
        if (!userToUpdateOptional.isPresent()) {
            return null;
        }

        // Since isPresent() was true, we can .get() the Person object out of the Optional
        Users userToUpdate = userToUpdateOptional.get();

        if (users.getName() != null) {
            userToUpdate.setName(users.getName());
        }
        if (users.getBalance() != null) {
            userToUpdate.setBalance(users.getBalance());
        }
        if (users.getEmail() != null) {
            userToUpdate.setEmail(users.getEmail());
        }


        Users updatedUser = this.usersRepository.save(userToUpdate);
        return updatedUser;
    }

    @DeleteMapping("/users/{id}")
    public Users deleteUser(@PathVariable("id") Integer id) {
        Optional<Users> userToDeleteOptional = this.usersRepository.findById(id);
        if (!userToDeleteOptional.isPresent()) {
            return null;
        }
        Users userToDelete = userToDeleteOptional.get();
        this.usersRepository.delete(userToDelete);
        return userToDelete;
    }
}
