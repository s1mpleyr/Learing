import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author
 * @data 2026/1/24
 */
public class CglibProxy implements MethodInterceptor {
    Object target;

    public CglibProxy(Object taarget) {
        this.target = taarget;
    }
    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();

    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB代理开始");
        Object result = method.invoke(target, objects);
        System.out.println("CGLIB代理结束");
        return result;
    }
}
