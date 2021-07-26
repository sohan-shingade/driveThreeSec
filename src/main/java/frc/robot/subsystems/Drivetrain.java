// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  public TalonSRX leftLead;
  public TalonSRX leftFollow;
  public TalonSRX rightLead;
  public TalonSRX rightFollow;
  /** Creates a new Drivetrain. */
  public Drivetrain() {

    leftLead = new TalonSRX(0);
    leftFollow = new TalonSRX(1);
    rightLead = new TalonSRX(2);
    rightFollow = new TalonSRX(3);

    rightFollow.follow(rightLead);
    leftFollow.follow(rightLead);

    rightLead.setInverted(true);
    rightFollow.setInverted(true);
  }

  /**
   * Runs the motors
   * @param left  percent output to the left side [-1 to 1]
   * @param right percent output to the right side [-1 to 1]
   */
  public void runMotors(double left, double right) {
    rightLead.set(ControlMode.PercentOutput, left);
    leftLead.set(ControlMode.PercentOutput, right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // log data to shuffleboard for debugging
    SmartDashboard.putNumber("Right Output", rightLead.getMotorOutputPercent());
    SmartDashboard.putNumber("Left Output", leftLead.getMotorOutputPercent());
  }
}
