package marcos_vinicius_almeida_pipeline;

public class Wb {
    Instrucao instrucaoSelect = new Instrucao(null, null, null, 0, 0, 0, 0,0,0);
    public void WriteRegister(Instrucao instrucao){
        if (instrucao.getTipo().equals("lw")){
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][0] = RegistradorMemoria.registradorMemoria.memoria[instrucao.getRegAux()];
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][1] = 0;
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][1] = 0;
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg3()][1] = 0;
        }else if (instrucao.getTipo().equals("add")||instrucao.getTipo().equals("sub")){
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][0] = instrucao.getRegAux();
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][1] = 0;
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][1] = 0;
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg3()][1] = 0;
        }else if (instrucao.getTipo().equals("mult")||instrucao.getTipo().equals("div")){
            RegistradorMemoria.registradorMemoria.hi = instrucao.getHi();
            RegistradorMemoria.registradorMemoria.lo = instrucao.getRegAux();
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][1] = 0;
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][1] = 0;
            RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg3()][1] = 0;
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
