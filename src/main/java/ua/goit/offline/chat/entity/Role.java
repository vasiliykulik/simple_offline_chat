package ua.goit.offline.chat.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by andreymi on 2/8/2017.
 */
@Entity
@Table(name = "roles", schema = "chat")
public class Role {
    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
