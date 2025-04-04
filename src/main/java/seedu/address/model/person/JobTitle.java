package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's job title in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidJobTitle(String)}
 */
public class JobTitle {
    public static final String MESSAGE_EXISTING_CONSTRAINTS =
            "Job role not recognised! Job role should be in saved list!\n"
            + "Use addJ to add another job role into the list.\n"
            + "Use listJ to list all job roles in saved list.";

    public static final String MESSAGE_NEW_CONSTRAINTS =
            "Invalid job role! Job role should only contain alphanumeric characters, \"(\", \")\" and spaces.";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}()][\\p{Alnum}() ]*";

    public final String value;

    /**
     * Constructs a {@code JobTitle}.
     *
     * @param jobTitle A valid job title that the candidate applied for.
     */
    public JobTitle(String jobTitle) {
        requireNonNull(jobTitle);
        checkArgument(isValidJobTitle(jobTitle), MESSAGE_NEW_CONSTRAINTS);
        value = jobTitle;
    }

    /**
     * Returns true if a given string is a valid job title.
     */
    public static boolean isValidJobTitle(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof JobTitle)) {
            return false;
        }

        JobTitle otherName = (JobTitle) other;
        return value.equals(otherName.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
