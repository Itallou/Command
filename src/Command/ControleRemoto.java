package Command;

public class ControleRemoto {
 private Command comandoLigar;
 private Command comandoDesligar;
 private Command comandoAumentarVolume;
 private Command comandoAbaixarVolume;

 public ControleRemoto(Command comandoLigar, Command comandoDesligar, Command comandoAumentarVolume, Command comandoAbaixarVolume) {
     this.comandoLigar = comandoLigar;
     this.comandoDesligar = comandoDesligar;
     this.comandoAumentarVolume = comandoAumentarVolume;
     this.comandoAbaixarVolume = comandoAbaixarVolume;
 }

 public void pressionarBotaoLigar() {
     comandoLigar.execute();
 }

 public void pressionarBotaoDesligar() {
     comandoDesligar.execute();
 }

 public void pressionarBotaoAumentarVolume() {
     comandoAumentarVolume.execute();
 }

 public void pressionarBotaoAbaixarVolume() {
     comandoAbaixarVolume.execute();
 }
}
