package sda.spring.beans;

public class ConstructorInjected {
	
	private SimpleBean simple;

	public ConstructorInjected(SimpleBean simple) {
		super();
		this.simple = simple;
	}

	public SimpleBean getSimple() {
		return simple;
	}

}
