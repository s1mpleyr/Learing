/**
 * @author
 * @data 2026/1/24
 */
public class Client {
    public static void main(String[] args) {
        S usr1 = new SImple();
        S proxy1 = (S) new JdkProxy(usr1).getProxy();
        proxy1.say();

        SImple usr2 = new SImple();
        SImple proxy2 =(SImple) new CglibProxy(usr2).getProxy();
        proxy2.say();
    }
}
