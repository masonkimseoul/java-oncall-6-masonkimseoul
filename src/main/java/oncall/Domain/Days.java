package oncall.Domain;

public enum Days {
    SUNDAY(0, "일", "휴일"),
    MONDAY(1, "월", "평일"),
    TUESDAY(2, "화", "평일"),
    WEDNESDAY(3, "수", "평일"),
    THURSDAY(4, "목", "평일"),
    FRIDAY(5, "금", "평일"),
    SATURDAY(6, "토", "휴일");

    private final int dayIndex;
    private final String dayName;
    private final String dayType;

    Days(int dayIndex, String dayName, String dayType) {
        this.dayIndex = dayIndex;
        this.dayName = dayName;
        this.dayType = dayType;
    }

    public int getDayIndex() {
        return this.dayIndex;
    }

    public String getDayName() {
        return this.dayName;
    }

    public String getDayType() {
        return this.dayType;
    }

    public static boolean isDayTypeWeekday(String dayName) {
        for (Days day : Days.values()) {
            if (day.getDayName().equals(dayName)
                    && day.getDayType().equals("평일")) {
                return true;
            }
        }
        return false;
    }
}
