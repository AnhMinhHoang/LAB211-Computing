/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import data_access.ComputingDao;
import model.BMIdata;

/**
 *
 * @author GoldCandy
 */
public class ComputeRepository implements IComputeRepository {

    @Override
    public void normalCalculator() {
        double total = ComputingDao.Instance().normalCalculator();
        System.out.printf("Result: %.2f", total);
    }

    @Override
    public void bmiCalculator(BMIdata bmiData) {
        String status = ComputingDao.Instance().bmiCalculator(bmiData);
        System.out.println("BMI Status: " + status);
    }
}
