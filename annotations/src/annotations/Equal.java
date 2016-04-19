package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import model.CompareBy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Equal {
	
	CompareBy compareBy();

}
