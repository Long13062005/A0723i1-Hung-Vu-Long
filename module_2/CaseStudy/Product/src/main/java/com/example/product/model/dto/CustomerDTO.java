package com.example.product.model.dto;

import com.example.product.model.Phone;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerDTO {
    private Integer id;
    @NotBlank(message = "Vui lòng không để trống")
    @Pattern(regexp = "^[A-Za-z0-9]*$",message = "Không được có ký tự đặc biệt")
    @Size(min = 6,max = 32,message = "Tên phải có ký tự từ 6 - 32")
    private String name;
    @Column(unique = true)
    @NotBlank(message = "Không được để trống")
    @Email(message = "Please Enter Valid Email Address")
    private String email;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(?:\\+?84|0)(?:3[2-9]|5[6-9]|7[0|6-9]|8[1-9]|9\\d)(?:\\d{7})$",message = "Theo định dạng số có 10 số")
    private String phoneNumber;
    private Phone phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }


    public CustomerDTO() {
    }

}
