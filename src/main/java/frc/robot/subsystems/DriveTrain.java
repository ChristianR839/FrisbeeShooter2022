// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

  private WPI_TalonSRX leftFrontDrive = new WPI_TalonSRX(4);
  private WPI_TalonSRX leftRearDrive = new WPI_TalonSRX(3);
  private WPI_TalonSRX rightFrontDrive = new WPI_TalonSRX(2);
  private WPI_TalonSRX rightRearDrive = new WPI_TalonSRX(1);

  private final MotorControllerGroup leftController = new MotorControllerGroup(leftFrontDrive, leftRearDrive);
  private final MotorControllerGroup rightController = new MotorControllerGroup(rightFrontDrive, rightRearDrive);

  private final DifferentialDrive driveTrain = new DifferentialDrive(leftController, rightController);

  private double ramp = 1.0;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftFrontDrive.configClosedloopRamp(ramp);
    leftRearDrive.configClosedloopRamp(ramp);
    rightFrontDrive.configClosedloopRamp(ramp);
    rightRearDrive.configClosedloopRamp(ramp);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Set both sides of the robot's drivetrain individually.
   * Front of robot = Direction frisbees are shot
   * @param leftPower Bidirectional: -1.0 to 1.0 (0 to stop)
   * @param rightPower Bidirectional: -1.0 to 1.0 (0 to stop)
   */
  public void drive(final double leftPower, final double rightPower) {
    driveTrain.tankDrive(leftPower, rightPower);
  }
}
