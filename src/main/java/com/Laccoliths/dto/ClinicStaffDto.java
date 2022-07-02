package com.Laccoliths.dto;

import com.Laccoliths.entity.ClinicStaff;

/**
 * @author Laccoliths
 */
public class ClinicStaffDto {
    private Integer code;
    private ClinicStaff clinicStaff;

    public ClinicStaff getClinicStaff() {
        return clinicStaff;
    }

    public void setClinicStaff(ClinicStaff clinicStaff) {
        this.clinicStaff = clinicStaff;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
