package Command;

public class LigarTVCommand implements Command {
 private TV tv;

 public LigarTVCommand(TV tv) {
     this.tv = tv;
 }

 @Override
 public void execute() {
     tv.ligar();
 }

 @Override
 public void undo() {
     tv.desligar();
 }
}
