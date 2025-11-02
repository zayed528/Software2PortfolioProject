package components.standard;

/**
 * Standard interface providing basic object operations for all components.
 * This interface defines the minimal contract that all OSU components must
 * satisfy.
 *
 * @param <T> the type of the component
 * @author Zayed Ali
 */
public interface Standard<T> {

    /**
     * Returns a new instance of the same dynamic type as this, with an initial
     * value.
     *
     * @return a new instance of type T
     * @ensures newInstance is empty and of the same dynamic type as this
     */
    T newInstance();

    /**
     * Resets this to an initial value.
     *
     * @clears this
     * @ensures this is in its initial state (empty)
     */
    void clear();

    /**
     * Transfers the value of source into this, leaving source empty.
     *
     * @param source
     *            the source object
     * @replaces this
     * @clears source
     * @ensures this = #source and source is empty
     */
    void transferFrom(T source);
}