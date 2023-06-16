package com.api.poo.apicomspring.exception;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String status;
    private String message;
    private String details;
}
