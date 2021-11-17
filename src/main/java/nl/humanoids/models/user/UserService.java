package nl.humanoids.models.user;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private Optional<User> getUser(ObjectId id) {
        return repository.findById(id);
    }

    private User addOrReplaceUser(User user) {
        Optional<User> existingUser = repository.findById(user._id);
        existingUser.ifPresent(value -> user._id = value._id);
        return repository.save(user);
    }

    private User addUser(User user) {
        return repository.save(user);
    }

    private void deleteUser(ObjectId id) {
        repository.deleteById(id);
    }

}
