package beans;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "cli_id")
		private int id;
		@Column(name = "cli_nome")
		private String nome;
		@Column(name = "cli_cpf")
		private String cpf;
		@Column(name = "cli_rg")
		private String rg;
		@Column(name = "cli_data_nasc")
		private Date data_nasc;
		@Column(name = "cli_rua")
		private String rua;
		@Column(name = "cli_bairro")
		private String bairro;
		@Column(name = "cli_cidade")
		private String cidade;
		@Column(name = "cli_uf")
		private char uf;
		@Column(name = "cli_cep")
		private Integer cep;
		@Column(name = "cli_email")
		private String email;
		@Column(name = "cli_senha")
		private String senha;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getRg() {
			return rg;
		}
		public void setRg(String rg) {
			this.rg = rg;
		}
		public Date getData_nasc() {
			return data_nasc;
		}
		public void setData_nasc(Date data_nasc) {
			this.data_nasc = data_nasc;
		}
		public String getRua() {
			return rua;
		}
		public void setRua(String rua) {
			this.rua = rua;
		}
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public char getUf() {
			return uf;
		}
		public void setUf(char uf) {
			this.uf = uf;
		}
		public Integer getCep() {
			return cep;
		}
		public void setCep(Integer cep) {
			this.cep = cep;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}

}
