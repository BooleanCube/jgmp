package com.boole.jgpm;

import com.boole.jgpm.math.helpers.JGMPCollisionHTest;
import com.boole.jgpm.math.helpers.JGMPFloatHTest;
import com.boole.jgpm.math.shapes.JGMPCircleTest;
import com.boole.jgpm.math.shapes.JGMPRay2Test;
import com.boole.jgpm.math.shapes.JGMPRectTest;
import com.boole.jgpm.math.vectors.JGMPVector2Test;
import com.boole.jgpm.physics.JGMPForceTest;
import com.boole.jgpm.physics.JGMPGravityTest;
import com.boole.jgpm.physics.JGMPVelocityTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        // Run Mathematics Tests
        runCollisionHTests();
        runFloatHTests();
        runCircleTests();
        runRay2Tests();
        runRectTests();
        runVector2Tests();

        // Run Physics Tests
        runForcesTests();
        runGravityTests();
        runVelocityTests();
    }

    static void runCollisionHTests() {
        Result result = JUnitCore.runClasses(JGMPCollisionHTest.class);
        System.out.println("Collision Helper Testing =>");
        for(Failure failure : result.getFailures())
            System.out.println("---> " + failure.toString());
        System.out.println(result.wasSuccessful() ? "Successful!" : "Failed!");
    }

    static void runFloatHTests() {
        Result result = JUnitCore.runClasses(JGMPFloatHTest.class);
        System.out.println("Float Helper Testing =>");
        for(Failure failure : result.getFailures())
            System.out.println("---> " + failure.toString());
        System.out.println(result.wasSuccessful() ? "Successful!" : "Failed!");
    }

    static void runCircleTests() {
        Result result = JUnitCore.runClasses(JGMPCircleTest.class);
        System.out.println("Circle Model Testing =>");
        for(Failure failure : result.getFailures())
            System.out.println("---> " + failure.toString());
        System.out.println(result.wasSuccessful() ? "Successful!" : "Failed!");
    }

    static void runRay2Tests() {
        Result result = JUnitCore.runClasses(JGMPRay2Test.class);
        System.out.println("2D Ray Model Testing =>");
        for(Failure failure : result.getFailures())
            System.out.println("---> " + failure.toString());
        System.out.println(result.wasSuccessful() ? "Successful!" : "Failed!");
    }

    static void runRectTests() {
        Result result = JUnitCore.runClasses(JGMPRectTest.class);
        System.out.println("2D Rect Model Testing =>");
        for(Failure failure : result.getFailures())
            System.out.println("---> " + failure.toString());
        System.out.println(result.wasSuccessful() ? "Successful!" : "Failed!");
    }

    static void runVector2Tests() {
        Result result = JUnitCore.runClasses(JGMPVector2Test.class);
        System.out.println("2D Vector Model Testing =>");
        for(Failure failure : result.getFailures())
            System.out.println("---> " + failure.toString());
        System.out.println(result.wasSuccessful() ? "Successful!" : "Failed!");
    }

    static void runForcesTests() {
        Result result = JUnitCore.runClasses(JGMPForceTest.class);
        System.out.println("Forces Model Testing =>");
        for(Failure failure : result.getFailures())
            System.out.println("---> " + failure.toString());
        System.out.println(result.wasSuccessful() ? "Successful!" : "Failed!");
    }

    static void runGravityTests() {
        Result result = JUnitCore.runClasses(JGMPGravityTest.class);
        System.out.println("Gravity Model Testing =>");
        for(Failure failure : result.getFailures())
            System.out.println("---> " + failure.toString());
        System.out.println(result.wasSuccessful() ? "Successful!" : "Failed!");
    }

    static void runVelocityTests() {
        Result result = JUnitCore.runClasses(JGMPVelocityTest.class);
        System.out.println("Velocity Model Testing =>");
        for(Failure failure : result.getFailures())
            System.out.println("---> " + failure.toString());
        System.out.println(result.wasSuccessful() ? "Successful!" : "Failed!");
    }

}
