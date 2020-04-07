package ir.maktab.quizer.repositories;

import ir.maktab.quizer.enums.Roles;
import ir.maktab.quizer.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long> {
    Role findRoleByTitle(Roles title);
}
