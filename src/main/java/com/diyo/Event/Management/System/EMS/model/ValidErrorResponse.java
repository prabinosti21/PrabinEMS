package com.diyo.Event.Management.System.EMS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidErrorResponse {
    private String field, errorMessage;
}
