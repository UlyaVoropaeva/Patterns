package ru.gb.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.entity.Role;

public interface RoleRepositoryAuth extends CrudRepository<Role, Long> {

}
