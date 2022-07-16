package test;

import main.CalendarLogic;
import main.Event;
import main.EventType;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class CalendarTest {
    private CalendarLogic calendarLogic = new CalendarLogic();

    @Test
    public void shouldSetBeNotEmpty () throws ParseException {
        Event event = new Event("urodziny", new SimpleDateFormat("dd/MM/yyyy").parse("22/02/1999"), new SimpleDateFormat("HH:mm").parse("18:00"), Duration.ofHours(4), EventType.BIRTHDAY);
        calendarLogic.addEvent(event);
        Assert.assertFalse(calendarLogic.getEventSet().isEmpty());
    }

    @Test
    public void shouldSetBeEmptyAfterDeletingOnlyOneExistingElement () throws ParseException {
        Event event = new Event("urodziny", new SimpleDateFormat("dd/MM/yyyy").parse("22/02/1999"), new SimpleDateFormat("HH:mm").parse("18:00"), Duration.ofHours(4), EventType.BIRTHDAY);
        calendarLogic.addEvent(event);
        calendarLogic.removeEvent("urodziny","22/02/1999");
        Assert.assertTrue(calendarLogic.getEventSet().isEmpty());
    }


    
}
