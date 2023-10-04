/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import repository.ComputeRepository;
import view.Menu;
import model.BMIdata;

/**
 *
 * @author GoldCandy
 */
public class ComputeController extends Menu {

    protected static String[] mc = {"Normal Calculator", "BMI Calculator", "Exit"};
    ComputeRepository computeRepository;

    public ComputeController() {
        super("Calculator Program", mc);
        computeRepository = new ComputeRepository();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                System.out.println("----- Normal Calculator -----");
                computeRepository.normalCalculator();
                break;
            }
            case 2: {
                System.out.println("----- BMI Calculator -----");
                computeRepository.bmiCalculator(new BMIdata());
                break;
            }
            case 3: {
                System.out.println("EXIT...");
                System.exit(0);
            }
            default: {
                System.err.println("No such choice!");
            }
        }
    }
}
