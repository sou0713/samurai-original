package com.example.demo.form;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignupForm {
	
	@NotBlank(message="{require_check}")
	@Email
	private String userId;
	
	@NotBlank
	@Length(min=4, max=100)
	@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String password;
	
	@NotBlank
	private String userName;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull
	private Date birthday;
	
	@Min(0)
	@Max(120)
	private Integer age;
	
	@NotNull
	private Integer gender;

}
