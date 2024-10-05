/*
 * Homework Problem set 1.
 *
 * Chika Otisi 20 Sept 2024.
 */

import java.util.Objects;

public class TimeSpan implements Comparable<TimeSpan>{
	private int hours;
	private int minutes;
	private TimeSpan(int hours, int minutes) {
		this.hours = hours;
		if (minutes >= 60) {
			this.hours += (minutes / 60);
			this.minutes = minutes % 60;
		} else {
			this.minutes = minutes;
		}
	}
	
	public static TimeSpan ofHours(int hours) {
		if (hours < 0) {
			throw new IllegalArgumentException();
		} else { 			
            return new TimeSpan(hours, 0);
		}
	}
	
	public static TimeSpan ofMinutes(int totalMinutes) {
		if (totalMinutes < 0) {
			throw new IllegalArgumentException();
		} else {
			return new TimeSpan(0, totalMinutes);
		}
	}
	
	public static TimeSpan ofHoursAndMinutes(int hours, int minutes) {
		if (hours < 0 || minutes < 0) {
			throw new IllegalArgumentException();
		} else {
			return new TimeSpan(hours, minutes);
		}
	}
	
	public int getHours() { return hours; }
	
	public int getMinutes() { return minutes; }
	
	public int getTotalMinutes() { return (hours * 60) + minutes; }
	
	@Override
	public String toString() { return hours + "h" + minutes + "m"; }
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof TimeSpan) {
			TimeSpan other = (TimeSpan) o;
			return this.getHours() == other.getHours() && this.getMinutes() == other.getMinutes();
		} else {
            return false;
        }
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(hours, minutes);
	}
	
	@Override
	public int compareTo(TimeSpan other) {
		return Integer.compare((this.getHours() * 60) + this.getMinutes(), (other.getHours() * 60) + other.getMinutes());
	}
	
	public TimeSpan plus(TimeSpan other) {
	    int newHours = this.getHours() + other.getHours(); 
        int newMinutes = this.getMinutes() + other.getMinutes();
        return new TimeSpan(newHours, newMinutes);
	}

    public TimeSpan plusHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException();
        } else {
            return new TimeSpan(getHours() + hours, getMinutes());
        }
    }

    public TimeSpan plusMinutes(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException();
        } else {
            return new TimeSpan(getHours(), getMinutes() + minutes);
        }
    }

    public TimeSpan plusHoursAndMinutes(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException();
        } else {
            return new TimeSpan(getHours() + hours, getMinutes() + minutes);
        }
    }
}
