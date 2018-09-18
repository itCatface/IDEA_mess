package cc.catface.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
@Aspect     // 表明切面
@Component  // 表明这是个bean由Spring管理
public class LoggerAspect {

    @Around(value = "execution(* cc.catface.spring.service.CommonService.*(..))")   // 对某个类中的所有方法进行切面操作
    public Object log(ProceedingJoinPoint point) throws Throwable {
        System.out.println("log start..." + point.getSignature().getName());
        Object object = point.proceed();
        System.out.println("log end..." + point.getSignature().getName());
        return object;
    }

}
