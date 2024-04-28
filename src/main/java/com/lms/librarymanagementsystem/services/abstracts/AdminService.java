package com.lms.librarymanagementsystem.services.abstracts;

import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.RegisterAdminRequest;

public interface AdminService {
	void register(RegisterAdminRequest request);
}
