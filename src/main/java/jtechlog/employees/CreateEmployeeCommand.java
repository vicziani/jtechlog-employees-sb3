package jtechlog.employees;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeCommand {

    @NotBlank(message = "Name can not be blank")
    private String name;
}
