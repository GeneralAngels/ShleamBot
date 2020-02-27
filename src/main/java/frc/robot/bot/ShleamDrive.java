package frc.robot.bot;

import com.ga2230.shleam.advanced.frc.FRCModule;
import com.ga2230.shleam.base.structure.Function;
import com.ga2230.shleam.base.structure.Result;
import edu.wpi.first.wpilibj.VictorSP;

public class ShleamDrive extends FRCModule {

    // Victors
    private VictorSP left, right;

    public ShleamDrive() {
        super("drive");

        // Initialize victors
        left = new VictorSP(0);
        right = new VictorSP(1);

        // Invert the right side
        right.setInverted(true);

        // Register functions
        // Sets speed
        register("power", new Function() {
            @Override
            public Result execute(String parameter) throws Exception {
                String[] powers = parameter.split(":");
                power(Double.parseDouble(powers[0]), Double.parseDouble(powers[1]));
                return null;
            }
        });
        // Drives
        register("drive", new Function() {
            @Override
            public Result execute(String parameter) throws Exception {
                String[] powers = parameter.split(":");
                drive(Double.parseDouble(powers[0]), Double.parseDouble(powers[1]));
                return null;
            }
        });
    }

    public void power(double left, double right) {
        this.left.set(left);
        this.right.set(right);
    }

    public void drive(double speed, double turn) {
        power(speed - turn, speed + turn);
    }
}
