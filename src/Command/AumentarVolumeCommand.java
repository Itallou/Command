package Command;

public class AumentarVolumeCommand implements Command {
 private TV tv;

 public AumentarVolumeCommand(TV tv) {
     this.tv = tv;
 }

 @Override
 public void execute() {
     tv.aumentarVolume();
 }

 @Override
 public void undo() {
     tv.abaixarVolume();
 }
}
