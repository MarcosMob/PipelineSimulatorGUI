package marcos_vinicius_almeida_pipeline;
public class Mem {
    Instrucao instrucaoSelect = new Instrucao(null, null, null, 0, 0, 0, 0,0,0);
    public void MemAloc(Instrucao instrucao){
        if (instrucao.getTipo().equals("sw")||instrucao.getTipo().equals("lw")){
            if (instrucao.getTipo().equals("sw")){
                RegistradorMemoria.registradorMemoria.memoria[instrucao.getRegAux()] = RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][0];
                RegistradorMemoria.registradorMemoria.ifAcesso = true;
            }
        }else if (instrucao.getTipo().equals("get_tc")){
            RegistradorMemoria.registradorMemoria.memoria[instrucao.getImediato()] = instrucao.getRegAux();
            RegistradorMemoria.registradorMemoria.ifAcesso = true;
        }else {
            RegistradorMemoria.registradorMemoria.ifAcesso = false;
        }
        instrucaoSelect = instrucao;
    }

    public Instrucao getInstrucaoSelect() {
        return instrucaoSelect;
    }

    public void setInstrucaoSelect(Instrucao instrucaoSelect) {
        this.instrucaoSelect = instrucaoSelect;
    }
}

