package z.learn.lang.enums;

public interface EnumInterface {

    enum Season implements EnumInterface {
        SPRING, SUMMER, WINTER, AUTUM;

        @Override
        public String description() {
            return null;
        }

        @Override
        public String defaultValue() {
            return null;
        }
    }


    String description();

    String defaultValue();
}
