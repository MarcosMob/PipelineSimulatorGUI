package marcos_vinicius_almeida_pipeline;
public class Instrucao {
    private String instrucao;
    private String tipo;
    private String instrucaoBin;
    private int reg1;
    private int reg2;
    private int reg3;
    private int imediato;
    private int regAux;
    private int hi;
    public Instrucao(String instrucao, String tipo, String instrucaoBin, int reg1, int reg2, int reg3, int imediato,int regAux,int hi) {
        this.instrucao = instrucao;
        this.tipo = tipo != null ? tipo : "";
        this.instrucaoBin = instrucaoBin;
        this.reg1 = reg1;
        this.reg2 = reg2;
        this.reg3 = reg3;
        this.imediato = imediato;
        this.regAux = regAux;
        this.hi = hi;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInstrucaoBin() {
        return instrucaoBin;
    }

    public void setInstrucaoBin(String instrucaoBin) {
        this.instrucaoBin = instrucaoBin;
    }

    public int getReg1() {
        return reg1;
    }

    public void setReg1(int reg1) {
        this.reg1 = reg1;
    }

    public int getReg2() {
        return reg2;
    }

    public void setReg2(int reg2) {
        this.reg2 = reg2;
    }

    public int getReg3() {
        return reg3;
    }

    public void setReg3(int reg3) {
        this.reg3 = reg3;
    }

    public int getImediato() {
        return imediato;
    }

    public void setImediato(int imediato) {
        this.imediato = imediato;
    }

    public int getRegAux() {
        return regAux;
    }

    public void setRegAux(int regAux) {
        this.regAux = regAux;
    }

    public int getHi() {return hi;}

    public void setHi(int hi) {this.hi = hi;}
}

