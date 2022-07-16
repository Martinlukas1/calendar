package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class CalendarLogic {

    Set<Event> eventSet;

    public CalendarLogic() {
        this.eventSet = new TreeSet<>();
    }

    Scanner scanner = new Scanner(System.in);
    public void addEvent() throws ParseException {
        System.out.println("Podaj nazwę wydarzenia");
        String name = scanner.nextLine();
        System.out.println("Podaj datę");
        String stringDate = scanner.nextLine();
        System.out.println("Podaj godzinę");
        String stringTime = scanner.nextLine();
        System.out.println("Podaj czas trwania (w godzinach)");
        long duration = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Podaj typ wydarzenia (CASUAL, BIRTHDAY, TRAINING)");
        String stringEventType = scanner.nextLine();

        Event event = new Event(name, new SimpleDateFormat("dd/MM/yyyy").parse(stringDate), new SimpleDateFormat("hh:mm").parse(stringTime), Duration.ofHours(duration), EventType.valueOf(stringEventType.toUpperCase()));
        eventSet.add(event);
    }

    public void addEvent(Event event) {
        eventSet.add(event);
    }

    public void removeEvent () throws ParseException {
        System.out.println("Podaj nazwę i datę wydarzenia, które chcesz usunąć");
        String name = scanner.nextLine();
        String stringDate = scanner.nextLine();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);

        Event searchingEvent = eventSet
                .stream()
                .filter(event -> event.getName().equals(name))
                .filter(event -> event.getDate().equals(date))
                .findFirst()
                .get();
        eventSet.remove(searchingEvent);
    }

    public void removeEvent (String name, String stringDate) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);

        Event searchingEvent = eventSet
                .stream()
                .filter(event -> event.getName().equals(name))
                .filter(event -> event.getDate().equals(date))
                .findFirst()
                .get();
        eventSet.remove(searchingEvent);
    }

    public void showEventByName (String name){
        Event searchingEvent = eventSet
                .stream()
                .filter(event -> event.getName().equals(name))
                .findAny()
                .get();

        System.out.println(searchingEvent);
    }
    public void showAllEvents (){
        eventSet.stream().forEach(System.out::println);
    }

    public void filterEvent (){}

    public void importEvents (){}

    public void exportEvents (){}

    public Set <Event> getEventSet (){
        return eventSet;
    }
}
