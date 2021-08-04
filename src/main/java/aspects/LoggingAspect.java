package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* controllers.*.*(..))")
    private void forControllers() {}

    @Pointcut("execution(* services.*.*(..))")
    private void forServices() {}

    @Pointcut("execution(* daos.*.*(..))")
    private void forDAOs() {}

    @Pointcut("forControllers() || forServices() || forDAOs()")
    private void combined() {}

    @Before("combined()")
    public void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info("############ @Before: " + method);

        Object[] args = joinPoint.getArgs();
        logger.info("Arguments: ");
        Arrays.stream(args).forEach(arg -> logger.info(arg.toString()));
    }

    @AfterReturning(
            pointcut = "combined()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String method = joinPoint.getSignature().toShortString();
        logger.info("@@@@@@@@@@ After Returning " + method);
        logger.info("Result: " + result);
    }
}
