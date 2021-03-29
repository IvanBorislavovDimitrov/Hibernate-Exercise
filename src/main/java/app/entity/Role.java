package app.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends IdEntity {

    @Column(nullable = false)
    private RoleType roleType;
    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> users = Collections.emptyList();

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public enum RoleType {
        USER, MODERATOR, ADMIN
    }
}
