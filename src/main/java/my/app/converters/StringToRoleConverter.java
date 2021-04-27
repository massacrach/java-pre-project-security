package my.app.converters;

import my.app.entities.Role;
import my.app.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringToRoleConverter implements Converter<String, Role> {
    private final RoleService roleService;
    private static final String NULL_REPRESENTATION = "";

    @Autowired
    public StringToRoleConverter(@Qualifier("RoleServiceJpaImpl") RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Role convert(String roleId) {
        if (roleId.equals(NULL_REPRESENTATION)) {
            return null;
        }

        try {
            Long id = Long.parseLong(roleId);
            Optional<Role> role = this.roleService.get(id);

            if (role.isEmpty()) {
                throw new RuntimeException("Role does not exist, ID:'" + roleId + "'");
            }

            return role.get();
        } catch (NumberFormatException e) {
            throw new RuntimeException("Could not convert '" + roleId + "' to a valid id");
        }
    }
}