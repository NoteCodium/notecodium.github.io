Jakarta filter is very powerful, can see raw request raw request and part of Tomcat

3. can see raw request and modify it
    1. Prevent
        1. abusive
        2. malicious
        3. misses some security token
4. Caching
5. 

```
@Component
@Order(1)
public class MF1 implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("MF1 doFilter arrival");
        chain.doFilter(request, response);//calls a function
        //this is the reaspn the next line will print in the end
        System.out.println("MF1 doFilter departure");
    }
}
```

vs 

Interceptor

```
@Component
public class MC1 implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("MC1 preHandle");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("MC1 postHandle");
    }
}
```

ServletRequest is an interface, HttpServletRequest is a child of it





