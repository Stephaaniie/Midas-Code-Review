package ar.com.codereview.api.codereview.enums;

/**
 * Aqui para cada tipo de mensaje se devuelve un valor int que esta asociado
 * como su id.
 */
public enum MessageType {

    MESSAGE (1, "message"), 
	ERROR (2, "error"),
	WARNING (3, "warning");
	
	private int id;
	private String name;
	
	private MessageType(final int id, final String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
