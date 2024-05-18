package br.com.pc2.trab2;

public class Aluno {
    private Integer matricula;
    private String nome;
    private Double[] notas;
    
    public Aluno(Integer matricula, String nome, int notas) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = new Double[notas];
    }
    

	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double[] getNotas() {
		return notas;
	}
	public void setNotas(Double[] notas) {
		this.notas = notas;
	}
}

