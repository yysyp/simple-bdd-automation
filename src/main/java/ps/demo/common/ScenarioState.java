package ps.demo.common;

import cn.hutool.core.annotation.AliasFor;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@ScenarioScope
public @interface ScenarioState {
    @AliasFor(annotation = Component.class)
    String value() default "";

}
