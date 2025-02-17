package marcos_vinicius_almeida_pipeline;
public class Id {
    Instrucao instrucaoSelect = new Instrucao(null, null, null, 0, 0, 0, 0,0,0);
    Instrucao bolha = new Instrucao("bolha","bolha","bolha",-1,-1,-1,-1,-1,-1);
    Instrucao pastInstruction = new Instrucao(null, null, null, 0, 0, 0, 0,0,0);
    public void decodificando (Instrucao instrucao){

        if (RegistradorMemoria.registradorMemoria.acesso){
            if (RegistradorMemoria.registradorMemoria.registrador[pastInstruction.getReg1()][1] == 1 || RegistradorMemoria.registradorMemoria.registrador[pastInstruction.getReg2()][1] == 1 || RegistradorMemoria.registradorMemoria.registrador[pastInstruction.getReg3()][1] == 1){
                instrucaoSelect = bolha;
            }else {
                RegistradorMemoria.registradorMemoria.acesso = false;
                instrucaoSelect = pastInstruction;
                if (instrucaoSelect.getTipo().equals("lw") || instrucaoSelect.getTipo().equals("div") || instrucaoSelect.getTipo().equals("mult") || instrucaoSelect.getTipo().equals("sub") || instrucaoSelect.getTipo().equals("add")) {
                    if (instrucaoSelect.getReg1() != 32) {
                        RegistradorMemoria.registradorMemoria.registrador[instrucaoSelect.getReg1()][1] = 1;
                    }
                }
            }
        }else {
            if (RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][1] != 1 && RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][1] != 1 && RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg3()][1] != 1) {
                if (instrucao.getTipo().equals("lw") || instrucao.getTipo().equals("div") || instrucao.getTipo().equals("mult") || instrucao.getTipo().equals("sub") || instrucao.getTipo().equals("add")) {
                    if (instrucao.getReg1() != 32) {
                        RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][1] = 1;
                    }
                }
                instrucaoSelect = instrucao;
            }else {
                RegistradorMemoria.registradorMemoria.acesso = true;
                instrucaoSelect = bolha;
                pastInstruction = instrucao;
            }
        }
    }

    public Instrucao getBolha() {
        return bolha;
    }

    public void setBolha(Instrucao bolha) {
        this.bolha = bolha;
    }

    public Instrucao getPastInstruction() {
        return pastInstruction;
    }

    public void setPastInstruction(Instrucao pastInstruction) {
        this.pastInstruction = pastInstruction;
    }

    public Instrucao getInstrucaoSelect() {
        return instrucaoSelect;
    }

    public void setInstrucaoSelect(Instrucao instrucaoSelect) {
        this.instrucaoSelect = instrucaoSelect;
    }
}

