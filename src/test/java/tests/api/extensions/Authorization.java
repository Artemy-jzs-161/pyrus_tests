package tests.api.extensions;

import org.junit.jupiter.api.extension.ExtendWith;
import java.lang.annotation.*;

@ExtendWith(AuthParameterResolver.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authorization {}