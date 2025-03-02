package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/api/add")
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}
	
	@GetMapping("/api/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
		// http://localhost:8080/add?operand1=111&operand2=1010
	}

/**
     * API endpoint for multiplying two binary numbers
     * Example: http://localhost:8080/multiply?operand1=111&operand2=1010
     */
    @GetMapping("/api/multiply")
    public String multiplyString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                 @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.multiply(number1, number2).getValue();
    }

    /**
     * API endpoint for multiplying two binary numbers in JSON format
     * Example: http://localhost:8080/multiply_json?operand1=111&operand2=1010
     */
    @GetMapping("/api/multiply_json")
    public BinaryAPIResult multiplyJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                       @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "multiply", number2, Binary.multiply(number1, number2));
    }

    /**
     * API endpoint for binary AND operation
     * Example: http://localhost:8080/and?operand1=111&operand2=1010
     */
    @GetMapping("/api/and")
    public String andString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                            @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.AND(number1, number2).getValue();
    }

    /**
     * API endpoint for binary AND operation in JSON format
     * Example: http://localhost:8080/and_json?operand1=111&operand2=1010
     */
    @GetMapping("/api/and_json")
    public BinaryAPIResult andJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                   @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "and", number2, Binary.AND(number1, number2));
    }

    /**
     * API endpoint for binary OR operation
     * Example: http://localhost:8080/or?operand1=111&operand2=1010
     */
    @GetMapping("/api/or")
    public String orString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                           @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.OR(number1, number2).getValue();
    }

    /**
     * API endpoint for binary OR operation in JSON format
     * Example: http://localhost:8080/or_json?operand1=111&operand2=1010
     */
    @GetMapping("/api/or_json")
    public BinaryAPIResult orJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                  @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "or", number2, Binary.OR(number1, number2));
    }


}