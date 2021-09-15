package com.example.SecondProjecdemo.Service;

import com.example.SecondProjecdemo.Model.User;
import com.example.SecondProjecdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user){
        this.userRepository.save(user);
    }

    @Override
   public User getUserById(long Id){
        Optional<User> optional = userRepository.findById(Id);
        User user = null;
        if (optional.isPresent()){
            user=optional.get();
        }else{
            throw new RuntimeException("Employee not find for id::" + Id);
        }
        return user;
    }

    @Override
    public void deleteUserById(long Id){
        this.userRepository.deleteById(Id);
    }


}
