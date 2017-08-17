package examples;

import java.util.ArrayList;
import java.util.List;

public class Rainfall {
    public static void main(String[] args) {
        List<Float> monthlyRainfall = new ArrayList<>(12);

        monthlyRainfall.add(5.41F);
        monthlyRainfall.add(4.78F);
        monthlyRainfall.add(6.39F);
        monthlyRainfall.add(3.91F);
        monthlyRainfall.add(4.38F);
        monthlyRainfall.add(6.37F);
        monthlyRainfall.add(7.99F);
        monthlyRainfall.add(6.60F);
        monthlyRainfall.add(5.83F);
        monthlyRainfall.add(3.96F);
        monthlyRainfall.add(4.46F);
        monthlyRainfall.add(3.92F);

        float total = 0.0F;
        for (float amount : monthlyRainfall) {
            total += amount;
        }
        System.out.println("Pensacola, FL");
        System.out.printf("Avg monthly rainfall  = %.2f\n",
                total / 12.0);
        System.out.printf("Total yearly rainfall = %.2f\n", total);
    }
}