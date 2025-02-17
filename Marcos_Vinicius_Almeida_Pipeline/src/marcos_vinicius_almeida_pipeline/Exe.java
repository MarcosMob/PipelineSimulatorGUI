package marcos_vinicius_almeida_pipeline;


import java.util.Scanner;
import javax.swing.JOptionPane;

public class Exe {
    Instrucao instrucaoSelect = new Instrucao(null, null, null, 0, 0, 0, 0,0,0);
    public void Execucao(Instrucao instrucao){
        Scanner scanner  = new Scanner(System.in);

        if (instrucao.getTipo().equals("get_tc")){
           instrucao.setRegAux(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor", "GET_TC OPTION", JOptionPane.PLAIN_MESSAGE)));
        }else if (instrucao.getTipo().equals("lw")||instrucao.getTipo().equals("sw")){
            instrucao.setRegAux(instrucao.getImediato() + instrucao.getReg2());
        }else if (instrucao.getTipo().equals("mult")||instrucao.getTipo().equals("div")){
            if (instrucao.getTipo().equals("mult")){
                int valor = RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][0] * RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][0];
                instrucao.setRegAux(valor);
                instrucao.setHi(0);
            }else{
                int valor = RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][0] /RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][0];
                int hi = RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][0] % RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][0];
                instrucao.setRegAux(valor);
                instrucao.setHi(hi);
            }
        }else if (instrucao.getTipo().equals("sub")||instrucao.getTipo().equals("add")){
            if(instrucao.getTipo().equals("sub")) {
                int value = RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][0] - RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg3()][0];
                instrucao.setRegAux(value);
            }else{
                int value = RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][0] + RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg3()][0];
                instrucao.setRegAux(value);
            }
        }else if (instrucao.getTipo().equals("beq")||instrucao.getTipo().equals("bne")){
            if (instrucao.getTipo().equals("beq")){
                if (RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][0] == RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][0]){
                    RegistradorMemoria.registradorMemoria.pc = instrucao.getImediato();
                }
            }else{
                if (RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][0]!=RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg2()][0]){
                    RegistradorMemoria.registradorMemoria.pc = instrucao.getImediato();
                }
            }
        }else if (instrucao.getTipo().equals("bgtz")||instrucao.getTipo().equals("bltz")){
            if (instrucao.getTipo().equals("bgtz")){
                if (RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][0]>0){
                    RegistradorMemoria.registradorMemoria.pc = instrucao.getImediato();
                }
            }else{
                if (RegistradorMemoria.registradorMemoria.registrador[instrucao.getReg1()][0]<0){
                    RegistradorMemoria.registradorMemoria.pc = instrucao.getImediato();
                }
            }
        }else if (instrucao.getTipo().equals("j")){
            RegistradorMemoria.registradorMemoria.pc = instrucao.getImediato();
        }else if (instrucao.getTipo().equals("jr")){
            RegistradorMemoria.registradorMemoria.pc = instrucao.getReg1();
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
