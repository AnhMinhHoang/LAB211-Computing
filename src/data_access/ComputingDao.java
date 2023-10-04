/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access;

import common.Validation;
import model.BMIdata;

/**
 *
 * @author GoldCandy
 */
public class ComputingDao {

    private static ComputingDao instance = null;
    private Validation valid = new Validation();

    public static ComputingDao Instance() {
        if (instance == null) {
            synchronized (ComputingDao.class) {
                if (instance == null) {
                    instance = new ComputingDao();
                }
            }
        }
        return instance;
    }

    public double normalCalculator() {
        double total = valid.inputDouble("Enter number");
        double number;
        String operator = "";
        while (!operator.equals("=")) {
            operator = valid.stringMatch("Enter Operator", "+-/*^");
            if (operator.equals("=")) {
                return total;
            }
            number = valid.inputDouble("Enter number");
            total = operatorHandle(operator, total, number);
            System.out.printf("Memory: %.2f\n", total);
        }
        return total;
    }

    private double operatorHandle(String operator, double total, double number) {
        switch (operator) {
            case "+": {
                return total + number;
            }
            case "-": {
                return total - number;
            }
            case "*": {
                return total * number;
            }
            case "/": {
                return total / number;
            }
        }
        return Math.pow(total, number);
    }

    public String bmiCalculator(BMIdata bmiData) {
        bmiData.setWeight(valid.inputDouble("Enter Weight(kg)"));
        bmiData.setHeight(valid.inputDouble("Enter Height(cm)"));
        double bmiNumber = bmiData.getWeight() * 10000 / (Math.pow(bmiData.getHeight(), 2));
        System.out.printf("BMI Number: %.2f\n", bmiNumber);
        return bmiStatusHandle(bmiNumber);
    }

    private String bmiStatusHandle(double bmiNumber) {
        if (bmiNumber < 19) {
            return "Under-standard";
        } else if (bmiNumber >= 19 && bmiNumber < 25) {
            return "Standard";
        } else if (bmiNumber >= 25 && bmiNumber < 30) {
            return "Overweight";
        } else if (bmiNumber >= 30 && bmiNumber < 40) {
            return "Fat - should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }
}
