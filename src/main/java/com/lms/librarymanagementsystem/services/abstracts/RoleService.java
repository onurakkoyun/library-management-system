package com.lms.librarymanagementsystem.services.abstracts;

import com.lms.librarymanagementsystem.entities.ERole;
import com.lms.librarymanagementsystem.entities.Role;

public interface RoleService {
	Role getByRoleName(ERole roleName);
}
