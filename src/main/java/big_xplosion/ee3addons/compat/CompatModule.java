package big_xplosion.ee3addons.compat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CompatModule {

	String id();

	String requiredMods() default "";

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	@interface Handler {

	}
}
