package main;

import java.io.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
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

    public void removeEvent() throws ParseException {
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

    public void removeEvent(String name, String stringDate) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);

        Event searchingEvent = eventSet
                .stream()
                .filter(event -> event.getName().equals(name))
                .filter(event -> event.getDate().equals(date))
                .findFirst()
                .get();
        eventSet.remove(searchingEvent);
    }

    public void showEventByName(String name) {
        Event searchingEvent = eventSet
                .stream()
                .filter(event -> event.getName().equals(name))
                .findAny()
                .get();

        System.out.println(searchingEvent);
    }

    public void showAllEvents() {
        eventSet.stream().forEach(System.out::println);
    }

    public void filterEvent() {
    }

    public Set<Event> importEvents(String path) {
        Set<Event> newSet = new TreeSet<>();

        try {
            Reader reader = new FileReader(path);
            BufferedReader bf = new BufferedReader(reader);
            String line = bf.readLine();

            while (line != null) {
                String[] modelAttributes = line.split(",");

                Event event = createEvent(modelAttributes);
                eventSet.add(event);
                line = bf.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newSet;
    }

    private Event createEvent(String[] modelAttributes) {
        String name = modelAttributes[0];
        Date date = Date.from(Instant.parse(modelAttributes[1]));
        Time time = Time.valueOf(modelAttributes[2]);
        Duration duration = Duration.parse(modelAttributes[3]);
        EventType type = EventType.valueOf(modelAttributes[4].toUpperCase());
        return new Event(name, date, time, duration, type);
    }

    public void exportEvents() {
    }

    public Set<Event> getEventSet() {
        return eventSet;
    }
}
