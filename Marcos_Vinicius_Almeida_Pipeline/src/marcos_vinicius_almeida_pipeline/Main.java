package marcos_vinicius_almeida_pipeline;

import javax.swing.JOptionPane;

public class Main {
    public static int clock = 0;
    public static  Instrucao instrucao = new Instrucao(null, null, null, 0, 0, 0, 0, 0, 0);
    public static  IF ifObject = new IF();
    public static  Id id = new Id();
    public static  Exe exe = new Exe();
    public static  Mem mem = new Mem();
    public static  Wb wb = new Wb();

    public Main() {
        // Inicialização dos registradores
        for (int i = 0; i < 32; i++) {
            RegistradorMemoria.registradorMemoria.registrador[i][0] = 0;
            RegistradorMemoria.registradorMemoria.registrador[i][1] = 0;
        }
    }

    // Método que executa uma iteração do pipeline
    public static void executePipeline(String arquivo) {
        // Executa uma iteração do ciclo
        wb.WriteRegister(mem.getInstrucaoSelect());
        mem.MemAloc(exe.getInstrucaoSelect());
        exe.Execucao(id.getInstrucaoSelect());
        id.decodificando(ifObject.getInstrucaoSelect());
        ifObject.readConfigTxt(arquivo);
        clock++;

        // Exibe o status atual
        System.out.println("Clock: " + clock + " PC: " + RegistradorMemoria.registradorMemoria.pc);
        System.out.println("IF: " + ifObject.getInstrucaoSelect().getTipo());
        System.out.println("ID: " + id.getInstrucaoSelect().getTipo());
        System.out.println("EXE: " + exe.getInstrucaoSelect().getTipo());
        System.out.println("MEM: " + mem.getInstrucaoSelect().getTipo());
        System.out.println("WB: " + wb.getInstrucaoSelect().getTipo());
        System.out.println("Instrucao: " + ifObject.getInstrucaoSelect().getInstrucao());
        System.out.println("----------------------");
        GUIpipeline.jTextField7.setText(String.valueOf(RegistradorMemoria.registradorMemoria.pc));
        GUIpipeline.jTextField5.setText(String.valueOf(clock));
        GUIpipeline.jTextField6.setText(ifObject.getInstrucaoSelect().getInstrucaoBin());
        GUIpipeline.hiText.setText(String.valueOf(RegistradorMemoria.registradorMemoria.hi));
        GUIpipeline.loText.setText(String.valueOf(RegistradorMemoria.registradorMemoria.lo));
        // Verifica se o ciclo terminou
        if (wb.getInstrucaoSelect().getTipo().equals("noop")) {
            JOptionPane.showMessageDialog(null, "Finalização do programa!", "Aviso", JOptionPane.WARNING_MESSAGE);
            System.out.println("Execution completed!");
        }
        
    }
    public static String[] retornaCanais(){
        String[] canais = {
        ifObject.getInstrucaoSelect().getTipo(),
        id.getInstrucaoSelect().getTipo(),
        exe.getInstrucaoSelect().getTipo(),
        mem.getInstrucaoSelect().getTipo(),
        wb.getInstrucaoSelect().getTipo()};
         
            return canais;
        }
    public static int[] retornaMemoria(){
        int [] memoria = new int[15];
        for(int i = 0; i < 15;i++){
         memoria[i] = RegistradorMemoria.registradorMemoria.memoria[i];
                }
        return memoria;
    }
    public static String[] retornaInstrucoes(){
        String [] instrucoes = new String[15];
        for(int i = 0; i < 15;i++){
         instrucoes[i] = RegistradorMemoria.registradorMemoria.memoriaInstruction[i];
                }
        return instrucoes;
    }
    public static int[] retornaReg15(){
        int [] memoria = new int[16];
        for(int i = 0; i < 16;i++){
         memoria[i] = RegistradorMemoria.registradorMemoria.registrador[i][0];
                }
        return memoria;
    }
    public static int[] retornaReg31(){
        int [] memoria = new int[16];
        for (int i = 0; i < 16; i++) {
            memoria[i] = RegistradorMemoria.registradorMemoria.registrador[i + 16][0];
        }
        return memoria;
    }
}
