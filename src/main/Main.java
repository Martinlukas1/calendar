package main;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        CalendarLogic calendarLogic = new CalendarLogic();
        menu();
        do {
            switch (sc.nextInt()) {
                case 1:
                    calendarLogic.addEvent();
                    break;
                case 2:
                    calendarLogic.removeEvent();
                    break;
                case 3:
                    calendarLogic.showAllEvents();
                    break;
                case 4:
                    calendarLogic.showEventByName(sc.nextLine());
                    break;
            }
            menu();
        }
        while (sc.nextInt() != 0);
    }

    public static void menu() {
        System.out.println("Menu główne aplikacji:");
        System.out.println("1- dodaj wydarzenie");
        System.out.println("2- usuń wydarzenie");
        System.out.println("3- wyświetl wszystkie wydarzenia");
        System.out.println("4- wyświetl wydarzenie o podanej nazwie");
    }
}
