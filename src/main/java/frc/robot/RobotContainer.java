// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.DPadButton.Direction;
import frc.robot.commands.TankDrive;
import frc.robot.commands.shooter.LiftDown;
import frc.robot.commands.shooter.LiftUp;
import frc.robot.commands.shooter.Feeder;
import frc.robot.commands.shooter.Flywheels;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  private final DriveTrain driveTrain = new DriveTrain();
  private final Shooter shooter = new Shooter();

  // Commands
  private final Flywheels flywheels = new Flywheels(shooter);
  private final Feeder feeder = new Feeder(shooter);
  private final LiftUp liftUp = new LiftUp(shooter);
  private final LiftDown liftDown = new LiftDown(shooter);

  // Controllers
  public XboxController driveController = new XboxController(0);

  // Buttons
  public JoystickButton YelBtnD = new JoystickButton(driveController, 4);
  public JoystickButton RedBtnD = new JoystickButton(driveController, 2);
  public JoystickButton BluBtnD = new JoystickButton(driveController, 3);
  public JoystickButton GrnBtnD = new JoystickButton(driveController, 1);
  public JoystickButton LBBtnD = new JoystickButton(driveController, 5);
  public JoystickButton RBBtnD = new JoystickButton(driveController, 6);

  // DPad
  public DPadButton DPadUpD = new DPadButton(driveController, Direction.UP);
  public DPadButton DPadDownD = new DPadButton(driveController, Direction.DOWN);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveTrain.setDefaultCommand(new TankDrive( () -> -driveController.getLeftY(), () -> -driveController.getRightY(), driveTrain));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    RedBtnD.whileHeld(flywheels);
    RBBtnD.whileHeld(feeder);

    DPadUpD.whileHeld(liftUp);
    DPadDownD.whileHeld(liftDown);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
