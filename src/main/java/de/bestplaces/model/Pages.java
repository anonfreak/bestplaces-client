package de.bestplaces.model;

/**
 * Created by kolbm on 01.05.2017.
 */
public enum Pages {
    WELCOME("Welcome"), TIMELINE("Timeline"), SEARCH("Search"), EDITUSERDATA("EditUserData");

    private final String text;

    /**
     * @param text
     */
    private Pages(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
