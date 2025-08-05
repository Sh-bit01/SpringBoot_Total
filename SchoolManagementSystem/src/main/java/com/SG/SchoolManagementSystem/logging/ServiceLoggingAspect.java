package com.SG.SchoolManagementSystem.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

@Aspect
@Component
public class ServiceLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLoggingAspect.class);

    // Pointcut for all classes annotated with @Service
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void serviceMethods() {}

    @Around("serviceMethods()")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        logger.info("[SERVICE START] {}.{}() - Args: {}", className, methodName, Arrays.toString(methodArgs));

        try {
            Object result = joinPoint.proceed(); // Proceed to actual method
            long duration = System.currentTimeMillis() - start;

            logger.info("[SERVICE END]   {}.{}() - Returned: {} | Duration: {} ms", className, methodName, result, duration);

            return result;
        } catch (Throwable ex) {
            long duration = System.currentTimeMillis() - start;

            logger.error("[SERVICE ERROR] {}.{}() - Exception: {} | Duration: {} ms", className, methodName, ex.getMessage(), duration, ex);
            throw ex;
        }
    }
}
