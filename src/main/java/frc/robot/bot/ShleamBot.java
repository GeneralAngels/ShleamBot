package frc.robot.bot;

import com.ga2230.shleam.advanced.frc.FRCRobot;
import com.ga2230.shleam.base.structure.Function;
import com.ga2230.shleam.base.structure.Result;
import edu.wpi.first.wpilibj.Joystick;

public class ShleamBot extends FRCRobot {

    // Joystick
    private Joystick joystick;

    // Child modules
    private ShleamDrive drive;

    public ShleamBot() {
        // Initialize a joystick
        joystick = new Joystick(0);

        // Initialize and adopt drive
        adopt(drive = new ShleamDrive());

        // Register some functions
        // This function outputs the joystick values
        register("joystick", new Function() {
            @Override
            public Result execute(String parameter) throws Exception {
                return Result.finished(String.valueOf(joystick.getX()));
            }
        });
    }

    @Override
    public void autonomousLoop() {
        // Run auto commands
        autonomous.next();
    }

    @Override
    public void teleopLoop() {
        // Set the drivetrain speed
        drive.drive(-joystick.getY(), joystick.getX());
    }
}
