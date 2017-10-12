package sda.spring.beans;

public class ConstructorInjected {
	
	private SimpleBean simple;
	private ComposedBean composed;
	private String text;

	public ConstructorInjected(SimpleBean simple, ComposedBean composed, String text) {
		super();
		this.simple = simple;
		this.composed = composed;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setSimple(SimpleBean simple) {
		this.simple = simple;
	}

	public ComposedBean getComposed() {
		return composed;
	}

	public void setComposed(ComposedBean composed) {
		this.composed = composed;
	}

	public SimpleBean getSimple() {
		return simple;
	}
	
	public void init(){
		System.out.println("ConstructorInjected utworzony");
	}
	
	

}
