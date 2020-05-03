package z.learn.lang;

/**
 * 没有匹配的时候会执行default，而且会顺序往下fall-through
 * default在前面的时候，匹配到了就不会执行default了
 * default在后面，匹配到了如果不break或者return，还会fall-through
 * 放在中间跟放在前面一样，没有命中时候fall-through，命中了不会执行default
 * -----start--------
 * Case 1
 * Case 2
 * --------1--------
 * Case 2
 * --------2--------
 * Case 3
 * --------3--------
 * default
 * Case 1
 * Case 2
 * --------4--------
 * Case 3
 * default
 * -------end--------
 * default
 * Case 3
 */
public class SwitchDemo {

    public static void main(String[] args) {
        System.out.println("-----start--------");
        switchDemo(1);
        System.out.println("--------1--------");
        switchDemo(2);
        System.out.println("--------2--------");
        switchDemo(3);
        System.out.println("--------3--------");
        switchDemo(4);
        System.out.println("--------4--------");
        int var = 3;
        switch (var) {
            case 1:
                System.out.println("Case 1");
            case 2:
                System.out.println("Case 2");
                break;
            case 3:
                System.out.println("Case 3");
            default:
                System.out.println("default");
        }
        System.out.println("-------end--------");
        var = 4;
        switch (var) {
            case 1:
                System.out.println("Case 1");
            case 2:
                System.out.println("Case 2");
                break;
            default:
                System.out.println("default");
            case 3:
                System.out.println("Case 3");
        }
    }

    private static void switchDemo(int var) {
        switch (var) {
            default:
                System.out.println("default");
            case 1:
                System.out.println("Case 1");
            case 2:
                System.out.println("Case 2");
                break;
            case 3:
                System.out.println("Case 3");
        }
    }
}
