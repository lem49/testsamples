package de.lem.pageobject;

public class Name {

	private int id;
	private String first;
    private String last;

    public Name() {
    }

    public Name(int id, String first, String last) {
    	this.id = id;
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String toString() {
        return last + ", " + first;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
