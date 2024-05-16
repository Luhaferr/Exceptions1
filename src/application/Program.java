/*
solução 1: muito uim, pois a lógica de validação é feita no programa principal, mas deveria ser feita na própria classe
solução 2: ruim, usamos um método retornando string jogando a lógica pra classe.
solução 3: boa, tratamento de exceções
 */
package application;

import entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = scanner.nextInt();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(scanner.next());
        System.out.print("Check-out date (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(scanner.next());
        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update reservation: ");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(scanner.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(scanner.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }
        scanner.close();
    }
}