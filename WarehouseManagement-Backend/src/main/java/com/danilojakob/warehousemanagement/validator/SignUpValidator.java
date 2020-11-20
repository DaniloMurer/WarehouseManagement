package com.danilojakob.warehousemanagement.validator;


import com.danilojakob.warehousemanagement.dtos.SignUpDto;
import com.danilojakob.warehousemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SignUpValidator implements Validator {

	private final UserRepository userRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return SignUpDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SignUpDto signUpDto = (SignUpDto) target;

		boolean somethingIsEmpty = false;

		if(signUpDto.getUsername() == null || signUpDto.getUsername().isBlank()){
			errors.reject("username", "validate.username.isBlank");
			somethingIsEmpty = true;
		}

		if(signUpDto.getPassword() == null || signUpDto.getPassword().isBlank()){
			errors.reject("password", "validate.password.isBlank");
			somethingIsEmpty = true;
		}

		if(signUpDto.getRepeatPassword() == null || signUpDto.getRepeatPassword().isBlank()){
			errors.reject("repeatPassword", "validate.repeatPassword.isBlank");
			somethingIsEmpty = true;
		}

		if(somethingIsEmpty){
			return;
		}

		if(userRepository.findByUsername(signUpDto.getUsername()).isPresent()){
			errors.reject("username", "validate.username.isForgiven");
		}

		boolean passwordsNotEqual = !signUpDto.getPassword().equals(signUpDto.getRepeatPassword());
		if(passwordsNotEqual){
			errors.reject("password", "validate.password.notEqualWithRepeat");
			errors.reject("repeatPassword", "validate.repeatPassword.notEqualWithPassword");
		}

	}
}
