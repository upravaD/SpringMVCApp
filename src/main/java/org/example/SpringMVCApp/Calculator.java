package org.example.SpringMVCApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Calculator {
    private Integer a;
    private Integer b;
    private String symbol;

    public Calculator(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Double addition() {
        symbol = " + ";
        return (double) a + b;
    }
    public Double subtraction() {
        symbol = " - ";
        return (double) a - b;
    }
    public Double multiplication() {
        symbol = " * ";
        return (double) (a * b);
    }
    public Double division() {
        symbol = " / ";
        return (double) a / (double) b;
    }
}
