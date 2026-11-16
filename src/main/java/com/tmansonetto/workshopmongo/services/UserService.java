package com.tmansonetto.workshopmongo.services;

import com.tmansonetto.workshopmongo.domain.User;
import com.tmansonetto.workshopmongo.dto.UserDTO;
import com.tmansonetto.workshopmongo.repository.UserRepository;
import com.tmansonetto.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> findAll () {
        return repo.findAll();
        
    }

    public User findById (String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }
    public User insert (User user) {
        return repo.insert(user);
    }
public User fromDTO (UserDTO dto) {
        return new User(dto.getId(),dto.getName(),dto.getEmail());
}
public void  deleteById (String id) {
        findById(id);
        repo.deleteById(id);
}

public User update (User user) {
        User newObj = findById(user.getId());
        updateData(newObj,user);
        return repo.save(newObj);
}

    private void updateData(User newObj, User user) {
        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }

}
