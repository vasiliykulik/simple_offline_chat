package ua.goit.offline.chat.entity;

import javax.persistence.*;

/**
 * Created by andreymi on 2/7/2017.
 */
@Entity
@Table(name = "messages", schema = "chat")
public class Message {
    @Id
    private Long id;
    private String text;
    @ManyToOne (fetch = FetchType.EAGER)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
