package ru.pryakhina.bookbase.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Around(value = "execution(* ru.pryakhina.bookbase.dao.*.*(..))")
    public Object arroundAllRepositoryMethodsAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        String nameMethod = methodSignature.getName();

        System.out.println("Begin of " + nameMethod);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println("End of " + nameMethod);
        return targetMethodResult;
    }
}
