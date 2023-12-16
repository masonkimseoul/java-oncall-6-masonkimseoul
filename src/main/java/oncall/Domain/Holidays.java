package oncall.Domain;

public enum Holidays {
    SHINJUNG(0, 1, 1, "휴일", "신정"),
    SAMIL(1, 3, 1, "휴일", "삼일절"),
    CHILDRENS(2, 5, 5, "휴일", "어린이날"),
    HYUNCHOONG(3, 6, 6, "휴일", "현충일"),
    GWANGBOK(4, 8, 15, "휴일", "광복절"),
    GAECHEON(5, 10, 3, "휴일", "개천절"),
    HANGEUL(6, 10, 9, "휴일", "한글날"),
    CHRISTMAS(7, 12, 25, "휴일", "성탄절");

    private final int holidayIndex;
    private final int month;
    private final int day;
    private final String dayType;
    private final String holidayName;

    Holidays(int holidayIndex, int month, int day, String dayType, String holidayName) {
        this.holidayIndex = holidayIndex;
        this.month = month;
        this.day = day;
        this.dayType = dayType;
        this.holidayName = holidayName;
    }

    public int getHolidayIndex() {
        return this.holidayIndex;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public String getDayType() {
        return this.dayType;
    }

    public String getHolidayName() {
        return this.holidayName;
    }

    public static boolean isSpecialHoliday(int monthInput, int dayInput) {
        for (Holidays holiday : Holidays.values()) {
            if (holiday.getMonth() == monthInput
                    && holiday.getDay() == dayInput) {
                return true;
            }
        }
        return false;
    }
}
