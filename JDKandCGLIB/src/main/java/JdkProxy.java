import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author
 * @data 2026/1/24
 */
public class JdkProxy {
    Object target;
    public JdkProxy(Object target) {
        this.target = target;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK代理开始");
                Object result = method.invoke(target,args);
                System.out.println("JDK代理结束");
                return result;
            }
        });
    }
}
