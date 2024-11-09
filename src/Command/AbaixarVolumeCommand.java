package Command;

public class AbaixarVolumeCommand implements Command {
 private TV tv;

 public AbaixarVolumeCommand(TV tv) {
     this.tv = tv;
 }

 @Override
 public void execute() {
     tv.abaixarVolume();
 }

 @Override
 public void undo() {
     tv.aumentarVolume();
 }
}
