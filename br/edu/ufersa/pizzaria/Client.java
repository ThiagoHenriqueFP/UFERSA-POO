package edu.ufersa.pizzaria;
class Cliente{
	private String name;
	private Address address = new Address();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name != null)
			if (name!="")
				this.name = name;
		
		this.name = "Franchesco";
	}
	
	
}