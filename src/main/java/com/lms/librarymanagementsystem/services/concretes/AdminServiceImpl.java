package com.lms.librarymanagementsystem.services.concretes;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.entities.Admin;
import com.lms.librarymanagementsystem.entities.ERole;
import com.lms.librarymanagementsystem.entities.Role;
import com.lms.librarymanagementsystem.repositories.AdminRepository;
import com.lms.librarymanagementsystem.services.abstracts.AdminService;
import com.lms.librarymanagementsystem.services.abstracts.RoleService;
import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.RegisterAdminRequest;
import com.lms.librarymanagementsystem.services.mappers.AdminMapper;
import com.lms.librarymanagementsystem.services.rules.abstracts.UserBusinessRuleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{
	
	private final AdminRepository adminRepository;

	private final PasswordEncoder passwordEncoder;
	
	private UserBusinessRuleService userBusinessRuleService;
	
	private RoleService roleService;
	
	@Override
	public void register(RegisterAdminRequest request) {
		
		userBusinessRuleService.checkIfEmailAlreadyExists(request.getEmail());
		
		userBusinessRuleService.checkIfPasswordsMatch(request.getPassword(), request.getPasswordConfirm());
		
		Admin admin = AdminMapper.INSTANCE.mapRegisterAdminRequestToAdmin(request);
		admin.setPassword(passwordEncoder.encode(request.getPassword()));
		
		Set<Role> roles = new HashSet<>();
		
		Role userRole = roleService.getByRoleName(ERole.ROLE_USER);
		roles.add(userRole);		
		
		Role adminRole = roleService.getByRoleName(ERole.ROLE_ADMIN);
		roles.add(adminRole);

		admin.setRoles(roles);
		
		adminRepository.save(admin);
	}
}
