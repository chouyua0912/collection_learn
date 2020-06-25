package z.learn.lang.enums;

public enum FoodEnum implements EnumInterface {
    Cake("hello", "sweet");

    FoodEnum(String description, String value) {
        this.description = description;
        this.value = value;
    }

    private String description;
    private String value;

    @Override
    public String description() {
        return description;
    }

    @Override
    public String defaultValue() {
        return value;
    }
}
