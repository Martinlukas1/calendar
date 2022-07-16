package main;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class Event implements Comparable<Event> {
    private String name;
    private Date date;
    private Date time;
    private Duration duration;

    private EventType eventType;

    public Event(String name, Date date, Date time, Duration duration, EventType eventType) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public int compareTo(Event event) {
        if (date == event.date) {
            return 0;
        } else if (date.compareTo(event.date) < 0) {
            return -1;
        } else return 1;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", duration=" + duration +
                ", eventType=" + eventType +
                '}';
    }
}
