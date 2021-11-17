package nl.humanoids.models.user;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    public ObjectId _id;

    @Indexed
    public String name;

    public String role;

    public User (String _name, String _role) {
        this.name = _name;
        this.role = _role;
    }

}