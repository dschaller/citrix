package framework;

/**
 * A condition that evaluates a feature of a subject
 * @author derekschaller
 *
 * @param <T> the subject to evaluate against
 * @param <F> the feature that will be evaluated within the condition
 */
public interface Condition<T, F> {
	public F of(T subject);
}
