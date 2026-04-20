package com.example.uservalidation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class UserRequest { 
     
    /* Username must:
     - Start with a letter
     - Contain letters and digits only
     - Length between 3 and 20 */
    @NotBlank(message = "Username is required")
    @Pattern(
    	    regexp = "^[A-Za-z][A-Za-z ]{2,19}$",
    	    message = "Username must start with a letter and can contain letters, digits, or spaces (3-20 chars)"
    	)
    
    private String userName;

    // Email must be valid format and not empty
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    // Phone number must:
    // - Be exactly 10 digits
    // - Start with 6,7,8 or 9
    @NotBlank(message = "Phone number is required")
    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Phone number must be 10 digits and start with 6,7,8 or 9"
    )
    private String phoneNumber;
}
    
//    1️⃣ Method: handleDuplicate
//    @ExceptionHandler(DuplicateResourceException.class)
//    public ResponseEntity<String> handleDuplicate(DuplicateResourceException ex) {
//        return ResponseEntity.badRequest().body(ex.getMessage());
//    }

//    Step-by-step explanation:
//
//    @ExceptionHandler(DuplicateResourceException.class)
//
//    Tells Spring: “If any controller or service throws a DuplicateResourceException, call this method.”
//
//    Example: Your service checks for duplicate email or username:
//
//    if(userRepository.existsByEmail(request.getEmail())) {
//        throw new DuplicateResourceException("Email already exists");
//    }


//    DuplicateResourceException ex
//
//    This parameter is the exception object that was thrown
//
//    ex.getMessage() will contain the message you passed: "Email already exists"
//
//    ResponseEntity.badRequest()
//
//    Creates a response with HTTP status 400 (Bad Request)
//
//    .body(ex.getMessage())
//
//    Sets the body of the response to the exception message
//
//    So the client gets just:
//
//    "Email already exists"
//
//
//    ✅ Summary: Any duplicate error → this method catches it → returns HTTP 400 with friendly message instead of a stack trace.
//
//    2️⃣ Method: handleValidation
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException ex) {
//        String errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(e -> e.getField() + ": " + e.getDefaultMessage())
//                .collect(Collectors.joining(", "));
//        return ResponseEntity.badRequest().body(errors);
//    }
//
//    Step-by-step explanation:
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//
//    Tells Spring: “If validation on a DTO (@Valid) fails, call this method.”
//
//    Example: User sends invalid username, email, or phone number
//
//    MethodArgumentNotValidException ex
//
//    Spring passes the exception object containing all validation errors
//
//    ex.getBindingResult().getFieldErrors()
//
//    Gets a list of all fields that failed validation
//
//    Each FieldError has:
//
//    field → the name of the invalid field
//
//    defaultMessage → the message from your annotation (@NotBlank, @Email, @Pattern)
//
//    .stream().map(...).collect(Collectors.joining(", "))
//
//    Converts the list of errors into a single string
//
//    Example:
//
//    "userName: Username is required, email: Invalid email format"
//
//
//    ResponseEntity.badRequest().body(errors)
//
//    Returns HTTP 400
//
//    Response body = the combined error messages
//
//    ✅ Summary: Any DTO validation error → this method catches it → returns friendly, readable messages instead of the default Spring JSON.
//
//    3️⃣ How the flow works together
//
//    Client sends request to POST /insertUser
//
//    Spring maps JSON → UserRequest DTO
//
//    @Valid triggers validation:
//
//    If invalid → throws MethodArgumentNotValidException → caught by handleValidation
//
//    Controller calls service (userService.registerUser)
//
//    Service checks duplicates:
//
//    If duplicate → throws DuplicateResourceException → caught by handleDuplicate
//
//    GlobalExceptionHandler returns friendly message and correct HTTP status
//
//    ✅ Key Idea
//
//    @ExceptionHandler = catch specific exceptions globally
//
//    GlobalExceptionHandler = central place for all exceptions
//
//    Without it, Spring shows default 500 error or messy JSON
//
//    With it, your API responses are clean, readable, and user-friendly

