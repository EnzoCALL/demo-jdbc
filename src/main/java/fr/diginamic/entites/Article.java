package fr.diginamic.entites;

public class Article {

	private int id;
	private String nom;

	public Article(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the designation
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param designation the designation to set
	 */
	public void setNom(String designation) {
		this.nom = nom;
	}

}
