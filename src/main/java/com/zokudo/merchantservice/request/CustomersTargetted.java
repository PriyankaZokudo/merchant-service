package com.zokudo.merchantservice.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class CustomersTargetted {
    String program_name;
    Integer count_of_program;

    @Override
    public String toString() {
        return "CustomersTargetted{" +
                "program_name='" + program_name + '\'' +
                ", count_of_program=" + count_of_program +
                '}';
    }

    public CustomersTargetted(String program_name, BigInteger count_of_program) {
        this.program_name = program_name;
        this.count_of_program = count_of_program.intValue();
    }
}
