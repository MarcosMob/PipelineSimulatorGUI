package marcos_vinicius_almeida_pipeline;
    import java.util.ArrayList;

    public class IF {
        Instrucao instrucaoSelect = new Instrucao(null, null, null, 32, 32, 32, 0,0,0);
        Instrucao bolha = new Instrucao("bolha","bolha","bolha",32,32,32,32,32,32);

        public void readConfigTxt(String arquivo) {
            ArrayList<String> dadosConfig = FileManager.stringReader("/Users/usuario/NetBeansProjects/Marcos_Vinicius_Almeida_Pipeline/src/marcos_vinicius_almeida_pipeline/"+arquivo+".txt");
            Instrucao instrucaoObj = new Instrucao(null, null, null, 0, 0, 0, 0, 0, 0);
            if (!RegistradorMemoria.registradorMemoria.acesso && !RegistradorMemoria.registradorMemoria.ifAcesso) {

                if (RegistradorMemoria.registradorMemoria.pc < dadosConfig.size()) {
                    instrucaoObj.setInstrucao(dadosConfig.get(RegistradorMemoria.registradorMemoria.pc));
                    RegistradorMemoria.registradorMemoria.pc++;
                    RegistradorMemoria.registradorMemoria.memoriaInstruction[RegistradorMemoria.registradorMemoria.count] = instrucaoObj.getInstrucao();
                    RegistradorMemoria.registradorMemoria.count++;

                    String[] particaoLinhaTxT = instrucaoObj.getInstrucao().split(" ");
                    String instrucao = particaoLinhaTxT[0];

                    if (instrucao.equals("get_tc")) {
                        String memData = particaoLinhaTxT[1];
                        String tipo = instrucao;
                        String memBin = FileManager.stringToBinaryString(memData, 10);
                        String op = "101010";
                        String imediato = "0000000000000000";
                        String instrucaoBin = op + memBin + imediato;
                        //System.out.println(instrucaoBin);


                        instrucaoObj.setTipo(tipo);
                        instrucaoObj.setInstrucaoBin(instrucaoBin);
                        instrucaoObj.setReg1(32);
                        instrucaoObj.setReg2(32);
                        instrucaoObj.setReg3(32);
                        instrucaoObj.setImediato(Integer.parseInt(memData));
                        instrucaoObj.setRegAux(32);

                    } else if (instrucao.equals("add") || instrucao.equals("sub")) {
                        String addOp = "000000";
                        String addFunc;
                        if (instrucao.equals("add")) {
                            addFunc = "100000";
                        } else {
                            addFunc = "100010";
                        }
                        String reg1 = particaoLinhaTxT[1].replaceAll("[$,]", "");
                        reg1 = FileManager.stringToBinaryString(reg1, 5);
                        String reg2 = particaoLinhaTxT[2].replaceAll("[$,]", "");
                        reg2 = FileManager.stringToBinaryString(reg2, 5);
                        String reg3 = particaoLinhaTxT[3].replaceAll("[$,]", "");
                        reg3 = FileManager.stringToBinaryString(reg3, 5);
                        String shamt = "00000";
                        String instrucaoBin = addOp + reg2 + reg3 + reg1 + shamt + addFunc;
                        //System.out.println(instrucaoBin);
                        //

                        instrucaoObj.setTipo(instrucao);
                        instrucaoObj.setInstrucaoBin(instrucaoBin);
                        instrucaoObj.setReg1(Integer.parseInt(reg1, 2));
                        instrucaoObj.setReg2(Integer.parseInt(reg2, 2));
                        instrucaoObj.setReg3(Integer.parseInt(reg3, 2));
                        instrucaoObj.setImediato(32);
                        instrucaoObj.setRegAux(32);

                    } else if (instrucao.equals("lw") || instrucao.equals("sw")) {
                        String lwOp;
                        if (instrucao.equals("lw")) {
                            lwOp = "100011";
                        } else {
                            lwOp = "101011";
                        }
                        String reg1 = particaoLinhaTxT[1].replaceAll("[$,]", "");
                        String reg2 = particaoLinhaTxT[2].replaceAll("[&,()]", "");
                        String[] parte = reg2.split("\\$");
                        reg2 = FileManager.stringToBinaryString(parte[1], 5);
                        String offset = FileManager.stringToBinaryString(parte[0], 16);
                        reg1 = FileManager.stringToBinaryString(reg1, 5);
                        String instrucaoBin = lwOp + reg2 + reg1 + offset;
                        //System.out.println(instrucaoBin);
                        //
                        instrucaoObj.setTipo(instrucao);
                        instrucaoObj.setInstrucaoBin(instrucaoBin);
                        instrucaoObj.setReg1(Integer.parseInt(reg1, 2));
                        instrucaoObj.setReg2(Integer.parseInt(reg2, 2));
                        instrucaoObj.setReg3(32);
                        instrucaoObj.setImediato(Integer.parseInt(offset, 2));
                        instrucaoObj.setRegAux(32);

                    } else if (instrucao.equals("mult") || instrucao.equals("div")) {
                        String multFunc;
                        String multOp = "000000";
                        if (instrucao.equals("div")) {
                            multFunc = "011010";
                        } else {
                            multFunc = "011000";
                        }
                        String shamt = "0000000000";
                        String reg1 = particaoLinhaTxT[1].replaceAll("[$,]", "");
                        reg1 = FileManager.stringToBinaryString(reg1, 5);
                        String reg2 = particaoLinhaTxT[2].replaceAll("[$,]", "");
                        reg2 = FileManager.stringToBinaryString(reg2, 5);
                        String instrucaoBin = multOp + reg2 + reg1 + shamt + multFunc;
                        //System.out.println(instrucaoBin);
                        //

                        instrucaoObj.setTipo(instrucao);
                        instrucaoObj.setInstrucaoBin(instrucaoBin);
                        instrucaoObj.setReg1(Integer.parseInt(reg1, 2));
                        instrucaoObj.setReg2(Integer.parseInt(reg2, 2));
                        instrucaoObj.setReg3(32);
                        instrucaoObj.setImediato(32);
                        instrucaoObj.setRegAux(32);

                    } else if (instrucao.equals("beq") || instrucao.equals("bne")) {
                        String opCode;
                        if (instrucao.equals("beq")) {
                            opCode = "000100";
                        } else {
                            opCode = "000101";
                        }
                        String reg1 = particaoLinhaTxT[1].replaceAll("[$,]", "");
                        reg1 = FileManager.stringToBinaryString(reg1, 5);
                        String reg2 = particaoLinhaTxT[2].replaceAll("[$,]", "");
                        reg2 = FileManager.stringToBinaryString(reg2, 5);
                        String offset = FileManager.stringToBinaryString(particaoLinhaTxT[3], 16);
                        String instrucaoBin = opCode + reg1 + reg2 + offset;
                        //System.out.println(instrucaoBin);
                        //

                        instrucaoObj.setTipo(instrucao);
                        instrucaoObj.setInstrucaoBin(instrucaoBin);
                        instrucaoObj.setReg1(Integer.parseInt(reg1, 2));
                        instrucaoObj.setReg2(Integer.parseInt(reg2, 2));
                        instrucaoObj.setReg3(32);
                        instrucaoObj.setImediato(Integer.parseInt(offset, 2));
                        instrucaoObj.setRegAux(32);
                    } else if (instrucao.equals("bltz") || instrucao.equals("bgtz")) {
                        String opCode;
                        String function;
                        if (instrucao.equals("bltz")) {
                            opCode = "000111";
                            function = "00000";
                        } else {
                            opCode = "000001";
                            function = "00001";
                        }
                        String reg1 = particaoLinhaTxT[1].replaceAll("[$,]", "");
                        reg1 = FileManager.stringToBinaryString(reg1, 5);
                        String offset = particaoLinhaTxT[2].replaceAll("[$,]", "");
                        offset = FileManager.stringToBinaryString(offset, 16);
                        String instrucaoBin = opCode + reg1 + function + offset;
                        //System.out.println(instrucaoBin);
                        //

                        instrucaoObj.setTipo(instrucao);
                        instrucaoObj.setInstrucaoBin(instrucaoBin);
                        instrucaoObj.setReg1(Integer.parseInt(reg1, 2));
                        instrucaoObj.setReg2(32);
                        instrucaoObj.setReg3(32);
                        instrucaoObj.setImediato(Integer.parseInt(offset, 2));
                        instrucaoObj.setRegAux(32);
                    } else if (instrucao.equals("j")) {
                        String opCode;
                        String offset;
                        opCode = "000010";
                        offset = FileManager.stringToBinaryString(particaoLinhaTxT[1], 26);
                        String instrucaoBin = opCode + offset;
                        //System.out.println(instrucaoBin);
                        //

                        instrucaoObj.setTipo(instrucao);
                        instrucaoObj.setInstrucaoBin(instrucaoBin);
                        instrucaoObj.setReg1(32);
                        instrucaoObj.setReg2(32);
                        instrucaoObj.setReg3(32);
                        instrucaoObj.setImediato(Integer.parseInt(offset, 2));
                        instrucaoObj.setRegAux(32);
                    } else if (instrucao.equals("jr")) {
                        String opCode = "000000";
                        String reg1;
                        // Todos são definidos como 00000 para a instrução JR
                        String rt = "00000";
                        String rd = "00000";
                        String shamt = "00000";
                        String function = "001000";
                        reg1 = particaoLinhaTxT[1].replaceAll("[$,]", "");
                        reg1 = FileManager.stringToBinaryString(reg1, 5);
                        String instrucaoBin = opCode + reg1 + rt + rd + shamt + function;
                        //System.out.println(instrucaoBin);
                        //

                        instrucaoObj.setTipo(instrucao);
                        instrucaoObj.setInstrucaoBin(instrucaoBin);
                        instrucaoObj.setReg1(Integer.parseInt(reg1, 2));
                        instrucaoObj.setReg2(32);
                        instrucaoObj.setReg3(32);
                        instrucaoObj.setImediato(32);
                        instrucaoObj.setRegAux(32);
                    } else if (instrucao.equals("noop")) {
                        instrucaoObj.setTipo(instrucao);
                        instrucaoObj.setInstrucaoBin("00000000000000000000000000000000");
                        instrucaoObj.setReg1(32);
                        instrucaoObj.setReg2(32);
                        instrucaoObj.setReg3(32);
                        instrucaoObj.setImediato(32);
                        instrucaoObj.setRegAux(32);
                    }

                    instrucaoSelect = instrucaoObj;
                } else {

                    instrucaoObj.setTipo("noop");
                    instrucaoObj.setInstrucaoBin("00000000000000000000000000000000");
                    instrucaoObj.setReg1(32);
                    instrucaoObj.setReg2(32);
                    instrucaoObj.setReg3(32);
                    instrucaoObj.setImediato(32);
                    instrucaoObj.setRegAux(32);
                    instrucaoSelect = instrucaoObj;
                }
            }
            else{
                instrucaoSelect = bolha;
            }
        }
        public Instrucao getInstrucaoSelect() {
            return instrucaoSelect;
        }

        public void setInstrucaoSelect(Instrucao instrucaoSelect) {
            this.instrucaoSelect = instrucaoSelect;
        }
    }

