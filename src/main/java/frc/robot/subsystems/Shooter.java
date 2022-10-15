// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

  // Flywheels
  private WPI_TalonSRX flywheelLow = new WPI_TalonSRX(6);
  private WPI_TalonSRX flywheelHigh = new WPI_TalonSRX(5);

  private MotorControllerGroup flywheels = new MotorControllerGroup(flywheelLow, flywheelHigh);

  // Feeder
  private WPI_TalonSRX feeder = new WPI_TalonSRX(7);

  // Lift
  private WPI_TalonSRX lift = new WPI_TalonSRX(8);

  /** Creates a new ExampleSubsystem. */
  public Shooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  /**
   * Sets both shooter flywheels to designated power.
   * @param power Bidirectional: -1.0 to 1.0 (0 to stop)
   */
  public void setFlywheels(double power) {
    flywheels.set(power);
  }

  /**
   * Run the window motor for a single revolution (measured by time).
   */
  public void setFeeder(double power) {
    feeder.set(power);
  }

  /**
   * Runs the lift at a designated power.
   * @param power Bidirectional: -1.0 to 1.0 (0 to stop)
   */
  public void liftAngle(double power) {
    lift.set(power);
  }
}
