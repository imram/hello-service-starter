package com.example.hello;

        import org.springframework.context.annotation.Conditional;

        import java.lang.annotation.*;

/**
 * Created by Ram Gupta on 5/14/2017.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(PropertyValueCheckCondition.class)
public @interface ConditionalOnWrongArgument {
}
