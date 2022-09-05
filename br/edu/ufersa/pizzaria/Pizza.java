class Pizza{
	private PizzaType pizza;
	private Adicionais adicionais;
	private float value;
	
	public float getValue() {
		return this.value;
	}
	
	public void setValue(float value) {
		if (value >= 0) this.value = value;
		else this.value = 45.00f;
	}
}