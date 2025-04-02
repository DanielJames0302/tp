package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Address address;

    // Data fields
    private final Label label;
    private final Remark remark;
    private final Set<JobTitle> jobTitles = new HashSet<>();
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address,
                  Label label, Remark remark, Set<JobTitle> jobTitles, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, label, remark, jobTitles, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.label = label;
        this.remark = remark;
        this.jobTitles.addAll(jobTitles);
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Label getLabel() {
        return label;
    }

    public Remark getRemark() {
        return remark;
    }

    /**
     * Returns an immutable JobTitle set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<JobTitle> getJobTitles() {
        return Collections.unmodifiableSet(jobTitles);
    }


    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && address.equals(otherPerson.address)
                && tags.equals(otherPerson.tags)
                && label.equals(otherPerson.label)
                && jobTitles.equals(otherPerson.jobTitles);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, jobTitles, label, remark, tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("label", label)
                .add("remark", remark)
                .add("applicable jobs", jobTitles)
                .add("tags", tags)
                .toString();
    }

}
