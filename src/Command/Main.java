package Command;

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();

        Command ligarTV = new LigarTVCommand(tv);
        Command desligarTV = new DesligarTVCommand(tv);
        Command aumentarVolume = new AumentarVolumeCommand(tv);
        Command abaixarVolume = new AbaixarVolumeCommand(tv);

        ControleRemoto controleRemoto = new ControleRemoto(ligarTV, desligarTV, aumentarVolume, abaixarVolume);

        controleRemoto.pressionarBotaoLigar();
        controleRemoto.pressionarBotaoAumentarVolume(); 
        controleRemoto.pressionarBotaoAbaixarVolume();  
        controleRemoto.pressionarBotaoDesligar();  
    }
}

