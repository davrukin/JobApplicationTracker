package net.davrukin.jobapplicationtracker.routines;

public class EmployeeLevelCounter {

    private static int[] employees = new int[]{1, 5, 7, 2, -1, 5, 7, 3, 1, 9};

    public static void main(String[] args) {

        System.out.println(getQuantity());

    }

    private static int getQuantity() {
        int quantity = 0;
        int tLevel = 3; // target
        int cLevel = 1; // current

        for (int i = 1; i < employees.length; i++) {
            int current = employees[i - 1];
            cLevel = 0;
            while (current != -1) {
                if (cLevel != tLevel) {

                }
                current++;
                cLevel++;
            }
        }
    }

}
