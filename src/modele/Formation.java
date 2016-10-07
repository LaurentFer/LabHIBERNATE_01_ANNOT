package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "FORMATION")
public class Formation {
	
	// Identifiant formation (Clé primaire)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	// Thème formation
	@Column(name = "THEME")
	private String theme;

	// Constructeur
	public Formation(String theme) {
		super();
		this.theme = theme;
	}
	
	// Getters et Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}

}