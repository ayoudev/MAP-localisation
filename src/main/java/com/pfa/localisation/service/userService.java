package com.pfa.localisation.service;

import com.pfa.localisation.entity.users;
import com.pfa.localisation.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    private userRepository uRepo;
    public void save(users u){
        uRepo.save(u);
    }
    public List<users> getAllUsers(){
        return uRepo.findAll();
    }
    public void deleteById(int id){
        uRepo.deleteById(id);
    }

    public boolean authenticate(String mail, String password) {
        // Chercher l'utilisateur par son email
        users user = uRepo.findByMail(mail);

        // Vérifier si l'utilisateur existe et si le mot de passe correspond
        return user != null && user.getPassword().equals(password);
    }
}
