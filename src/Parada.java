public class Parada implements Comparable<Parada>{
 
    public int km;
	public String name;

	public Parada(int km, String name){
		this.km=km;
		this.name=name;
	}

    public int getKm(){
		return this.km;
	}

	//Compara duas requisicoes pelo tempo de finalizacao
	@Override public int compareTo(Parada parada) {
		return parada.km - this.km;
	}
	
	@Override public String toString(){
		return "[" + name + "km:" + km + " ]";
	}

}