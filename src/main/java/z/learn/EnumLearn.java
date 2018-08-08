package z.learn;

/**
 * 编译后继承自java.lang.Enum
 * EnumLearn.class
 * 'EnumLearn$Weekday.class'
 * javap 命令反编译
 * <p>
 * z@z:~/IdeaProjects/collectionlearn/target/classes/z/learn$ javap -c EnumLearn\$Weekday.class
 * Compiled from "EnumLearn.java"
 * final class z.learn.EnumLearn$Weekday extends java.lang.Enum<z.learn.EnumLearn$Weekday> {
 * public static final z.learn.EnumLearn$Weekday MONDAY;
 * public static final z.learn.EnumLearn$Weekday TUESDAY;
 * public static final z.learn.EnumLearn$Weekday WEDNESDAY;
 * public static final z.learn.EnumLearn$Weekday THURSDAY;
 * public static final z.learn.EnumLearn$Weekday FRIDAY;
 * public static final z.learn.EnumLearn$Weekday SATURDAY;
 * public static final z.learn.EnumLearn$Weekday SUNDAY;
 *
 *  public static z.learn.EnumLearn$Weekday[] values();
 *     Code:
 *        0: getstatic     #1                  // Field $VALUES:[Lz/learn/EnumLearn$Weekday;
 *        3: invokevirtual #2                  // Method "[Lz/learn/EnumLearn$Weekday;".clone:()Ljava/lang/Object;
 *        6: checkcast     #3                  // class "[Lz/learn/EnumLearn$Weekday;"
 *        9: areturn
 */
public class EnumLearn {

    public void example() {
        Weekday day = Weekday.MONDAY;
        Weekday day2 = Weekday.FRIDAY;

        if (day.compareTo(day2) < 0) {
            System.out.println(day);
        }
    }

    enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
