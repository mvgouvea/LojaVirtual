package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fone")
public class Fone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fon_id;
	@Column(name = "fon_numero")
	private String fon_numero;
	@Column(name = "fon_descricao")
	private String fon_descricao;

	public Integer getFon_id() {
		return fon_id;
	}

	public void setFon_id(Integer fon_id) {
		this.fon_id = fon_id;
	}

	public String getFon_numero() {
		return fon_numero;
	}

	public void setFon_numero(String fon_numero) {
		this.fon_numero = fon_numero;
	}

	public String getFon_descricao() {
		return fon_descricao;
	}

	public void setFon_descricao(String fon_descricao) {
		this.fon_descricao = fon_descricao;
	}
}
