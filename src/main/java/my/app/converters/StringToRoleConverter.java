package my.app.converters;

import my.app.entities.Role;
import my.app.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToRoleConverter implements Converter<String, Role> {
    @Autowired
    private RoleService roleService;
    private static final String NULL_REPRESENTATION = "";

    public StringToRoleConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public Role convert(String roleId) {
        if (roleId.equals(NULL_REPRESENTATION)) {
            return null;
        }

        try {
            Long id = Long.parseLong(roleId);

            return this.roleService.get(id);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Could not convert '" + roleId + "' to a valid id");
        }
    }
}