package ga.veee.day12.delivery;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class TimeTakes {
    public static void main(String[] args) {
        LocalDateTime dispatchTime = LocalDateTime.now().withHour(10).withMinute(0).withSecond(0).withNano(0);

        System.out.println(DeliveryTimeUtils.getDeliveryTime(dispatchTime, 60, 430, 8));
    }

}

class Time {
    private int hour;
    private int minute;
    private int second;
    private long nano;
    private long timeNano;
    private Div req;
    private static Time obj;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public long getNano() {
        return nano;
    }

    public long getNanoTime() {
        return this.timeNano;
    }

    public static Time ofNano(long timeNano) {
        if (obj == null) {
            obj = new Time();
        }
        obj.timeNano = timeNano;
        obj.nano = timeNano;
        obj._updateTime();
        return obj;
    }

    private void _updateTime() {
        if (timeNano > 0) {
            req = Div.divide(this.timeNano, (60 * 60 * 1000000000L));
            this.hour = (int) req.getDiv();
            Div.divide(req.getRem(), (60 * 1000000000L));
            this.minute = (int) req.getDiv();
            Div.divide(req.getRem(), 1000000000L);
            this.second = (int) req.getDiv();
            this.nano = req.getRem();
        }
    }

    public Time minus(long value, TimeUnit timeUnit) {
        switch (timeUnit) {
            case HOURS -> {
                timeNano -= value * (60 * 60 * 1000000000L);
                _updateTime();
            }
            case MINUTES -> {
                timeNano -= value * (60 * 1000000000L);
                _updateTime();
            }
            case SECONDS -> {
                timeNano -= value * (1000000000L);
                _updateTime();
            }
            case NANOS -> {
                timeNano -= value;
                _updateTime();
            }
        }
        return obj;
    }

    public Time plus(long value, TimeUnit timeUnit) {
        switch (timeUnit) {
            case HOURS -> {
                timeNano += value * (60 * 60 * 1000000000L);
                _updateTime();
            }
            case MINUTES -> {
                timeNano += value * (60 * 1000000000L);
                _updateTime();
            }
            case SECONDS -> {
                System.out.println(TimeUnit.SECONDS);
                timeNano += value * (1000000000L);
                _updateTime();
            }
            case NANOS -> {
                System.out.println(TimeUnit.NANOS);
                timeNano += value;
                _updateTime();
            }
        }
        return obj;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d.%09d", hour, minute, second, nano);
    }
}

class Div {
    private static Div obj;

    private long div;
    private long rem;

    public long getDiv() {
        return div;
    }

    public long getRem() {
        return rem;
    }

    static Div divide(long num, long div) {
        if (obj == null) {
            obj = new Div();
        }
        if (num > 0) {
            obj.div = num / div;
            obj.rem = num % div;
        }

        return obj;
    }

}

class DeliveryTimeUtils {
    /**
     * @param dispatchDateTime - Date and time of the dispatch
     * @param kph              - Average Vehicle speed in Kilo Meters per Hour
     * @param totalDistance    - Delivery location distance in Kilo Meter
     * @param workingHours     - Total working hours per day in Hours
     */
    public static LocalDateTime getDeliveryTime(LocalDateTime dispatchDateTime, int kph, int totalDistance, int workingHours) {

        long workingHoursNano = workingHours * (60 * 60 * 1000000000L);

        Time requiredTime = Time.ofNano((long) ((float) (totalDistance * 1000) / (float) (kph * 1000) * 60 * 60 * 1000000000L));

        while (true) {
            System.out.println(requiredTime);
            if (!isHoliday(dispatchDateTime.toLocalDate())) {
                if (workingHoursNano < requiredTime.getNanoTime()) {
                    dispatchDateTime = dispatchDateTime.plus(1, ChronoUnit.DAYS);
                    requiredTime = requiredTime.minus(workingHoursNano, TimeUnit.NANOS);
                } else {
                    dispatchDateTime = dispatchDateTime.plus(requiredTime.getNanoTime(), ChronoUnit.NANOS);
                    requiredTime = requiredTime.minus(requiredTime.getNanoTime(), TimeUnit.NANOS);
                    break;
                }
            }
        }

        return dispatchDateTime;

    }


    /**
     * Checks given date weather is holiday or not
     *
     * @param ld - Date to be checked in LocalDateTime
     * @return - boolean true -> Holiday | false -> WorkingDay
     */
    private static boolean isHoliday(LocalDate ld) {
        for (Holidays holiday : Holidays.values()) {
            if (holiday.name().equals(ld.getDayOfWeek().toString())) {
                return true;
            } else if (holiday.getDate() != null) {
                if (holiday.getDate().getDayOfMonth() == ld.getDayOfMonth() && holiday.getDate().getMonth() == ld.getMonth())
                    return true;
            }
        }
        return false;
    }
}

/**
 * List of time units used by Time
 */
enum TimeUnit {
    NANOS,
    SECONDS,
    MINUTES,
    HOURS
}

/**
 * List of holidays in a year
 */
enum Holidays {
    SUNDAY(),
    JAN_1(LocalDate.now().withMonth(1).withDayOfMonth(1)),
    JAN_26(LocalDate.now().withMonth(1).withDayOfMonth(26)),
    AUG_15(LocalDate.now().withMonth(8).withDayOfMonth(15)),
    OCT_15(LocalDate.now().withMonth(10).withDayOfMonth(2));

    private LocalDate date;

    /**
     * Set the the holiday
     *
     * @param date - Set the holiday - LocalDate
     */
    Holidays(LocalDate date) {
        this.date = date;
    }

    Holidays() {
    }

    /**
     * get the date of an holiday
     *
     * @return - Return the holiday Date (LocalDate)
     */
    LocalDate getDate() {
        return this.date;
    }
}