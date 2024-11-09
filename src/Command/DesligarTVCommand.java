package Command;

public class DesligarTVCommand implements Command {
 private TV tv;

 public DesligarTVCommand(TV tv) {
     this.tv = tv;
 }

 @Override
 public void execute() {
     tv.desligar();
 }

 @Override
 public void undo() {
     tv.ligar();
 }
}
