package marcos_vinicius_almeida_pipeline;

public class RegistradorMemoria {
    int[] memoria = new int[1000];
    int[][] registrador = new int[33][2];
    String[] memoriaInstruction = new String[1000];
    int lo;
    int hi;
    int pc;
    int count;
    boolean acesso;
    boolean ifAcesso;
    private RegistradorMemoria(int[] memoria, int[][] registrador,String[] memoriaInstruction,int pc,int count,int hi,int lo,boolean acesso,boolean ifAcesso) {
        this.memoria = memoria;
        this.registrador = registrador;
        this.memoriaInstruction = memoriaInstruction;
        this.pc = pc;
        this.count = count;
        this.lo = lo;
        this.hi = hi;
        this.acesso = acesso;
        this.ifAcesso = ifAcesso;
    }
    public static RegistradorMemoria registradorMemoria = new RegistradorMemoria(new int[1000],new int[33][2],new String[1000], 0,0,0,0,false,false);
}
