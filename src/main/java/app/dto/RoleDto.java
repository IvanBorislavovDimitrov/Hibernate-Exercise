package app.dto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RoleDto extends IdDto {

    @NotNull
    private String roleType;
    private List<UserDto> roles = new ArrayList<>();

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public List<UserDto> getRoles() {
        return roles;
    }

    public void setRoles(List<UserDto> roles) {
        this.roles = roles;
    }
}
