
import java.util.Scanner;



public class TrigonometryLab{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean keepRunning = true;

      
        while (keepRunning) {
            System.out.println("1. Basic Trig Calculator");
            System.out.println("2. Angle Quadrant Finder");
            System.out.println("3. Right Triangle Solver");
            System.out.println("4. Trig Identity Checker");
            System.out.println("5. Coordinate Converter");
            System.out.println("0. Exit Program");
            System.out.print("Choose a problem to solve (0-5): ");

            int choice = input.nextInt();

            
            switch (choice) {
                case 1:
                    problem1(input);
                    break;
                case 2:
                    problem2(input);
                    break;
                case 3:
                    problem3(input);
                    break;
                case 4:
                    problem4(input);
                    break;
                case 5:
                    problem5(input);
                    break;
                case 0:
                    keepRunning = false; 
 
                    break;
                default:
                    System.out.println("Please pick a number from 0 to 5.");
            }
        }

        
        input.close();
    }

    /**
     * Problem 1: Calculates sin, cos, or tan for an angle.
     */
    public static void problem1(Scanner input) {
        System.out.println("\n--- Problem 1: Basic Trig Calculator ---");
        System.out.print("Enter an angle in degrees: ");
        double degrees = input.nextDouble();

        System.out.println("Which function do you want?");
        System.out.println("  1: Sine | 2: Cosine | 3: Tangent | 4: All Three");
        System.out.print("Your choice: ");
        int choice = input.nextInt();

      
        double radians = Math.toRadians(degrees);

        if (choice == 1) {
            System.out.printf("Sine(%.1f°) = %.4f%n",  Math.sin(radians));
        } else if (choice == 2) {
            System.out.printf("Cosine(%.1f°) = %.4f%n", Math.cos(radians));
        } else if (choice == 3) {
           
            if (Math.abs(degrees % 180 - 90) < 0.001) {
                System.out.println("Tangent at "  + "° is undefined");
            } else {
                System.out.printf("Tangent(%.1f°) = %.4f%n",  Math.tan(radians));
            }
        } else if (choice == 4) {
            System.out.printf("Sine(%.1f°) = %.4f%n",  Math.sin(radians));
            System.out.printf("Cosine(%.1f°) = %.4f%n",  Math.cos(radians));
            if (Math.abs(degrees % 180 - 90) < 0.001) {
                System.out.println("Tangent at "  + "° is undefined");
            } else {
                System.out.printf("Tangent(%.1f°) = %.4f%n",  Math.tan(radians));
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    /*
     Why convert to radians?
Java's math functions only understand radians, not degrees. We have to convert so the computer can do the math correctly.

What makes tangent undefined?
Tangent is sin / cos. At 90° and 270°, cos is zero. You can't divide by zero, so tangent is undefined.

How to add reciprocal functions?
Just flip the original functions: csc = 1 / sin, sec = 1 / cos, and cot = 1 / tan. Add menu options and check for division by zero.
     */

    /**
     * Problem 2: Finds which quadrant an angle is in.
     */
    public static void problem2(Scanner input) {
        System.out.println("Problem 2: Angle Quadrant Finder");
        System.out.print("Enter an angle in degrees: ");
        double degrees = input.nextDouble();

       
        double normalizedAngle = (degrees % 360 + 360) % 360;
        System.out.printf("%.1f° is in the same direction as %.1f°.%n", degrees, normalizedAngle);
        
        
        if (normalizedAngle == 0 || normalizedAngle == 360) {
            System.out.println("It's on the positive X-axis (the line to the right).");
        } else if (normalizedAngle == 90) {
            System.out.println("It's on the positive Y-axis (the line going up).");
        } else if (normalizedAngle == 180) {
            System.out.println("It's on the negative X-axis (the line to the left).");
        } else if (normalizedAngle == 270) {
            System.out.println("It's on the negative Y-axis (the line going down).");
        }
     
        else if (normalizedAngle < 90) {
            System.out.println("It's in Quadrant I (top-right).");
        } else if (normalizedAngle < 180) {
            System.out.println("It's in Quadrant II (top-left).");
        } else if (normalizedAngle < 270) {
            System.out.println("It's in Quadrant III (bottom-left).");
        } else {
            System.out.println("It's in Quadrant IV (bottom-right).");
        }
    }

    /*
    Problem 2: Angle Quadrant Detector
    Why normalize angles?
    To make things simple. An angle like 400° points the same way as 40°. Normalizing gets rid of the extra spins to get an easy number between 0° and 360°.

    How do signs change across quadrants?
    The signs match the (x, y) coordinates on a graph. cos is like x, sin is like y. In the top-left quadrant (II), x is negative and y is positive, so cos is negative and sin is positive.

    What's special about angles on axes?
    They aren't in any quadrant; they're the boundaries. At these angles, sin or cos is zero, which can make other functions undefined.
     */

    /**
     * Problem 3: Solves a right triangle.
     */
    public static void problem3(Scanner input) {
        System.out.println("Problem 3: Right Triangle Solver");
       
        double a = 0, b = 0, c = 0, angleA = 0, angleB = 0;

        System.out.println("What pieces of the triangle puzzle do you have?");
        System.out.println("  1: Two Sides");
        System.out.println("  2: One Side and One Angle");
        System.out.print("Your choice: ");
        int choice = input.nextInt();

        if (choice == 1) { 
            System.out.println("Which two sides? (c is the long one, the hypotenuse)");
            System.out.println("  1: The two shorter legs (a and b)");
            System.out.println("  2: A short leg and the hypotenuse (a and c)");
            System.out.print("Your choice: ");
            int sideChoice = input.nextInt();

            if (sideChoice == 1) { 
                System.out.print("Enter length of leg 'a': ");
                a = input.nextDouble();
                System.out.print("Enter length of leg 'b': ");
                b = input.nextDouble();

                
                c = Math.sqrt(a * a + b * b);
                
                angleA = Math.toDegrees(Math.atan(a / b));
                angleB = 90 - angleA; 
            } else { 
                System.out.print("Enter length of the short leg: ");
                a = input.nextDouble();
                System.out.print("Enter length of the hypotenuse 'c': ");
                c = input.nextDouble();

               
                if (a >= c) {
                    System.out.println("Error! The hypotenuse 'c' must be the longest side.");
                    return;
                }
                
                b = Math.sqrt(c * c - a * a);
                angleA = Math.toDegrees(Math.asin(a / c));
                angleB = 90 - angleA;
            }
        } else { 
            System.out.print("Enter the side's length: ");
            double side = input.nextDouble();
            System.out.print("Enter the angle in degrees (not the 90° one): ");
            angleA = input.nextDouble();

         
            if (angleA <= 0 || angleA >= 90) {
                System.out.println("Error! The angle must be between 0 and 90 degrees.");
                return;
            }

            angleB = 90 - angleA;
            double angleARad = Math.toRadians(angleA);

            System.out.println("How is the side related to the angle? (SOH CAH TOA)");
            System.out.println("  1: It's OPPOSITE the angle");
            System.out.println("  2: It's ADJACENT (next to) the angle");
            System.out.println("  3: It's the HYPOTENUSE (the long one)");
            System.out.print("Your choice: ");
            int relationChoice = input.nextInt();
            
            
            if (relationChoice == 1) { 
                a = side;
                b = a / Math.tan(angleARad); 
                c = a / Math.sin(angleARad); 
            } else if (relationChoice == 2) { 
                b = side;
                a = b * Math.tan(angleARad); 
                c = b / Math.cos(angleARad); 
            } else { 
                c = side;
                a = c * Math.sin(angleARad); 
                b = c * Math.cos(angleARad); 
            }
        }

        System.out.println("Triangle Solved");
        System.out.printf("Sides: a=%.2f, b=%.2f, c=%.2f%n", a, b, c);
        System.out.printf("Angles: A=%.2f°, B=%.2f°, C=90°%n", angleA, angleB);
        System.out.printf("Area: %.2f%n", 0.5 * a * b);
    }

    /*
    Problem 3: Right Triangle Solver
Why must angles be < 90°?
A triangle's angles add up to 180°. A right triangle already uses 90°, leaving only 90° for the other two angles to share.

How does the program handle different cases?
It uses if-else statements. Based on your input (e.g., two sides), it chooses the correct formulas (Pythagorean Theorem or SOH CAH TOA) to solve the triangle.

What if you enter invalid values?
The program validates the input. If you enter something impossible (like a leg longer than the hypotenuse), it will show an error message instead of crashing.
     */


    /**
     * Problem 4: Checks if famous trig identities are true.
     */
    public static void problem4(Scanner input) {
        System.out.println("Problem 4: Trig Identity Checker ");
        
      
        final double TOLERANCE = 0.00000001;

        System.out.print("Enter an angle in degrees to test: ");
        double degrees = input.nextDouble();
        double radians = Math.toRadians(degrees);

       
        System.out.println("\nChecking: sin²(θ) + cos²(θ) = 1");
        double leftSide1 = Math.pow(Math.sin(radians), 2) + Math.pow(Math.cos(radians), 2);
        double rightSide1 = 1.0;
        System.out.printf("  Left side result:  %.8f%n", leftSide1);
        System.out.printf("  Right side result: %.8f%n", rightSide1);
        if (Math.abs(leftSide1 - rightSide1) < TOLERANCE) {
            System.out.println("  Result: Looks TRUE");
        } else {
            System.out.println("  Result: Something is wrong. ");
        }

        
        System.out.println("\nChecking: 1 + tan²(θ) = sec²(θ)");
      
        if (Math.abs(Math.cos(radians)) < TOLERANCE) {
            System.out.println("  Result: This identity is UNDEFINED at this angle.");
        } else {
            double leftSide2 = 1 + Math.pow(Math.tan(radians), 2);
            double secant = 1 / Math.cos(radians);
            double rightSide2 = Math.pow(secant, 2);
            System.out.printf("  Left side result:  %.8f%n", leftSide2);
            System.out.printf("  Right side result: %.8f%n", rightSide2);
            if (Math.abs(leftSide2 - rightSide2) < TOLERANCE) {
                System.out.println("  Result: Looks TRUE");
            } else {
                System.out.println("  Result: Something is wrong");
            }
        }
    }

    /*
     Problem 4: Trigonometric Identity Verifier
Why use a tolerance?
Computers have tiny rounding errors with decimals (e.g., 0.99999... instead of 1). A tolerance checks if numbers are "close enough" to be considered equal.

Which identity has the most issues?
The one with tan and sec. Both divide by cos, so when cos is almost zero, the results get huge and tiny errors are magnified.

How to check more identities easily?
Create a reusable method. It would take two formulas (left and right sides) and an angle, then automatically do the calculation and tolerance check. */
     
    /**
     * Problem 5: Converts between (x, y) and (r, θ) coordinates.
     */
    public static void problem5(Scanner input) {
        System.out.println("Problem 5: Coordinate Converter");
        System.out.println("Which way do you want to convert?");
        System.out.println("  1: Polar (radius, angle) -> to -> Cartesian (x, y)");
        System.out.println("  2: Cartesian (x, y)      -> to -> Polar (radius, angle)");
        System.out.print("Your choice: ");
        int choice = input.nextInt();

        if (choice == 1) { 
            System.out.print("Enter the radius 'r': ");
            double r = input.nextDouble();
            System.out.print("Enter the angle in degrees: ");
            double thetaDegrees = input.nextDouble();

            
            double thetaRadians = Math.toRadians(thetaDegrees);
            double x = r * Math.cos(thetaRadians);
            double y = r * Math.sin(thetaRadians);
            System.out.printf("The (x, y) coordinates are (%.3f, %.3f)%n", x, y);

        } else if (choice == 2) { // Cartesian to Polar
            System.out.print("Enter the 'x' coordinate: ");
            double x = input.nextDouble();
            System.out.print("Enter the 'y' coordinate: ");
            double y = input.nextDouble();

            
            double r = Math.sqrt(x * x + y * y);
            
          
            double thetaRadians = Math.atan2(y, x);
            double thetaDegrees = Math.toDegrees(thetaRadians);
            
            
            thetaDegrees = (thetaDegrees % 360 + 360) % 360;

            System.out.printf("The Polar coordinates are (radius=%.3f, angle=%.3f°)%n", r, thetaDegrees);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    /*
     Problem 5: Wave Analyzer Answers
How did you determine if the wave is at a peak or trough?
A sine wave is at a peak (its highest point, +1) when the angle is 90°. It's at a trough (its lowest point, -1) at 270°. The code just checks if the angle matches these values.

What mathematical approach did you use to find the next peak?
Peaks repeat every 360°. The program starts at the first peak (90°) and keeps adding 360° until it finds the next peak that comes after the user's input angle.

How would you modify this program to handle non-sinusoidal waves?
You would need more advanced math. Simple trig wouldn't work. You'd have to use calculus (to find where the slope is zero) or other complex methods to analyze irregular wave shapes.
     */
}