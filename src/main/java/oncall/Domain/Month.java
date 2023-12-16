package oncall.Domain;

public enum Month {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    private final int months;
    private final int days;

    Month(int months, int days) {
        this.months = months;
        this.days = days;
    }

    public int getDay() {
        return days;
    }

    public int getMonth() {
        return months;
    }

    public static int getDays(int monthInput) {
        for(Month month : Month.values()) {
            if (monthInput == month.getMonth()) {
                return month.getDay();
            }
        }
        return 0;
    }
}
