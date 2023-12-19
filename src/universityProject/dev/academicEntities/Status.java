package universityProject.dev.academicEntities;

/**
 * @author Asyl
 * @version 18.12.2023
 * The Status enum represents the status of an order, which can be CREATED, SOLVED, or REJECTED.
 */
public enum Status {

    /** Represents an order that has been created but not yet resolved. */
    CREATED,

    /** Represents an order that has been successfully solved. */
    SOLVED,

    /** Represents an order that has been rejected or could not be resolved. */
    REJECTED
}
