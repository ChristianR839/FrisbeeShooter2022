// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends CommandBase {

  private final DriveTrain driveTrain;

  private final DoubleSupplier left;
  private final DoubleSupplier right;

  /** Creates a new TankDrive. */
  public TankDrive(DoubleSupplier leftPower, DoubleSupplier rightPower, DriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    this.left = leftPower;
    this.right = rightPower;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPower = left.getAsDouble();
    double rightPower = right.getAsDouble();

    driveTrain.drive(leftPower, rightPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
