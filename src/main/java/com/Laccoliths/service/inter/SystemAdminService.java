package com.Laccoliths.service.inter;


import com.Laccoliths.dto.SystemAdminDto;

/**
 * @author MSI
 */
public interface SystemAdminService {
    public SystemAdminDto login(String username, String password);
}
