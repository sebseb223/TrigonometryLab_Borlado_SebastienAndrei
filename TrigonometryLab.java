
import java.util.Scanner;



public class TrigonometryLab{

    public static void main(String[] args) {
      System.out.println("Trigonometric Function Calculator!!!");
        System.out.println("input an angle in degrees my duds");
        Scanner input=new Scanner(System.in) ;
        double degrees = input.nextDouble();
                
        System.out.println("Choose a function:");
        System.out.println("1: Sine");
        System.out.println("2: Cosine");
        System.out.println("3: Tangent");
        System.out.println("4: All three");
        
        int choice = input.nextInt();
        double radians = Math.toRadians(degrees);
        
        
        
        if (choice==1){
            System.out.println("Sine:" + Math.sin(radians));
        }
        else if (choice==2){
            System.out.println("Cosine:" + Math.cos(radians));
        }
        else if (choice==3){
            if(Math.abs(degrees % 180)==90){
                System.out.println("Tangent: undefined bro");
        }   else {
                System.out.println("Tangent:" + Math.tan(radians));
            }
        }
        else if (choice==4){
            System.out.println("Sine:" + Math.sin(radians));
            System.out.println("Cosine:" + Math.cos(radians));
            
            if(Math.abs(degrees % 180)==90){
                System.out.println("Tangent: undefined bro");
        }   else {
                System.out.println("Tangent:" + Math.tan(radians));
            }}
        
        
        /* critical questions
            1.Why convert degrees to radians?
            Computers do their angle math using radians, not degrees. 
            We have to convert so the computer understands the number we give it.

            2.Why is tangent undefined?
            Tangent is calculated as sine divided by cosine. At 90° and 270°,
            cosine is zero, and you can't divide by zero in math.

            3.How do you add reciprocal functions?
            Just add new menu options and the calculations for them:
            Cosecant = 1 / sine
            Secant = 1 / cosine
            Cotangent = 1 / tangent
            You also need to add checks to prevent dividing by zero for each new function.
        */
        
        
        System.out.println("trigo problem number 2");
        System.out.println("input an angle in degrees");
        double angleProb2 = input.nextDouble();
        double normalizedAngle= angleProb2 % 360;
        if (normalizedAngle < 0){normalizedAngle += 360;}
        System.out.println("angle is normalized to " + normalizedAngle);
        
        /* need e normalized kay biskan unsa ka dako like 670degrees kay ma convert ra siya ug
            katumbas ras 0degrees to 360degrees
            "normalizedAngle < 0" meaning negative numbers
            "normalizedAngle += 360" ma convert ang negative to postive, dugangag 360. 
            ingani siya "normalizedAngle = normalizedAngle + 360"
        */
        
        
        if (normalizedAngle == 0) {
                System.out.println("the angle is on the positive X-axis.");
                System.out.println("Sine is Zero, Cosine is Positive, Tangent is Zero.");
            } else if (normalizedAngle == 90) {
                System.out.println("The angle is on the positive Y-axis.");
                System.out.println("Sine is Positive, Cosine is Zero, Tangent is Undefined.");
            } else if (normalizedAngle == 180) {
                System.out.println("The angle is on the negative X-axis.");
                System.out.println("Sine is Zero, Cosine is Negative, Tangent is Zero.");
            } else if (normalizedAngle == 270) {
                System.out.println("The angle is on the negative Y-axis.");
                System.out.println("Sine is Negative, Cosine is Zero, Tangent is Undefined.");
            }
            
            
            else if (normalizedAngle > 0 && normalizedAngle < 90) {
                System.out.println("The angle is in Quadrant I.");
                System.out.println("Sine: Positive (+)");
                System.out.println("Cosine: Positive (+)");
                System.out.println("Tangent: Positive (+)");
            } else if (normalizedAngle > 90 && normalizedAngle < 180) {
                System.out.println("The angle is in Quadrant II.");
                System.out.println("Sine: Positive (+), Cosine: Negative (-), Tangent: Negative (-)");
            } else if (normalizedAngle > 180 && normalizedAngle < 270) {
                System.out.println("The angle is in Quadrant III.");
                System.out.println("Sine: Negative (-), Cosine: Negative (-), Tangent: Positive (+)");
            } else if (normalizedAngle > 270 && normalizedAngle < 360) {
                System.out.println("The angle is in Quadrant IV.");
                System.out.println("Sine: Negative (-), Cosine: Positive (+), Tangent: Negative (-)");
            }
    
        /* critical questions
            1. Why normalize angles?
            To simplify any angle (like 450° or -90°) to a value between 0° and 360°,
            which makes finding its quadrant easy.

            2.How do function signs change?
            The signs change in each quadrant. The easiest way to remember which function 
            is positive is with the phrase "All Students Take Calculus":
            Q1: All
            Q2: Sine
            Q3: Tangent
            Q4: Cosine

            3. What's special about angles on the axes?
            Angles on an axis (0°, 90°, 180°, 270°) aren't in any quadrant. On these lines,
            sine or cosine is zero, which can make other functions like tangent become zero
            or undefined.
    */
    
        System.out.println("Problem 3: Right Triangle Solver");
        System.out.println("which elements you know?");
        System.out.println("1. two sides");
        System.out.println("2. one side and one angle ");
        int choiceProb3 = input.nextInt();
        
        if (choiceProb3 == 1) {
            System.out.println("do you know the hypotenouse?");
            System.out.println("1.yes");
            System.out.println("2.no");
            int choiceSulodSaProb3 = input.nextInt();

            if (choiceSulodSaProb3 == 1) { // User knows hypotenuse (c) and one leg (a)
                System.out.println("input the hypotenouse");
                double c = input.nextDouble();
                System.out.println("input the other side");
                double a = input.nextDouble();

                if (c <= a || a <= 0) {
                    System.out.println("Error: Dapat mas taas ang hypotenuse kaysa sa leg, ug dapat positive ang values.");
                } else {
                    double b = Math.sqrt((c * c) - (a * a)); 

                    double angleA = Math.toDegrees(Math.asin(a / c));
                    double angleB = 90 - angleA;
                    double area = 0.5 * a * b;

                    System.out.println("Results:");
                    System.out.println("Missing Side (b): " + b);
                    System.out.println("Angle A: " + angleA + " degrees");
                    System.out.println("Angle B: " + angleB + " degrees");
                    System.out.println("Area: " + area);
                }

            } else if (choiceSulodSaProb3 == 2) { // User knows the two legs (a and b)
                System.out.println("input the first side");
                double a = input.nextDouble(); // 'firstSide'
                System.out.println("input the second side");
                double b = input.nextDouble(); // 'secondSide'

                if (a <= 0 || b <= 0) {
                    System.out.println("Error: Dapat positive ang values sa sides.");
                } else {
                    double c = Math.sqrt((a * a) + (b * b)); // 'thirdSide'

                    double angleA = Math.toDegrees(Math.atan(a / b));
                    double angleB = 90 - angleA;
                    double area = 0.5 * a * b;

                    System.out.println("Results:");
                    System.out.println("Missing Side (Hypotenuse): " + c);
                    System.out.println("Angle A: " + angleA + " degrees");
                    System.out.println("Angle B: " + angleB + " degrees");
                    System.out.println("Area: " + area);
                }
            }

        } else if (choiceProb3 == 2) {
            System.out.println("input the side");
            double side = input.nextDouble();
            System.out.println("input the angle");
            double angleA = input.nextDouble(); 
            
            if (side <= 0 || angleA <= 0 || angleA >= 90) {
                System.out.println("Error: Dapat positive ang side ug ang angle kay tali sa 0 ug 90.");
            } else {
                double angleB = 90 - angleA; 
                double angleA_rad = Math.toRadians(angleA); 

                System.out.println("which side?");
                System.out.println("1.Hypotenuse");
                System.out.println("2.Opposite");
                System.out.println("3.Adjacent");
                int whichSide = input.nextInt(); 

                double a = 0, b = 0, c = 0;

                if (whichSide == 1) { // Hypotenuse (c)
                    c = side;
                    a = c * Math.sin(angleA_rad);
                    b = c * Math.cos(angleA_rad);
                } else if (whichSide == 2) { // Opposite (a)
                    a = side;
                    c = a / Math.sin(angleA_rad);
                    b = a / Math.tan(angleA_rad);
                } else if (whichSide == 3) { // Adjacent (b)
                    b = side;
                    c = b / Math.cos(angleA_rad);
                    a = b * Math.tan(angleA_rad);
                } else {
                    System.out.println("Invalid choice.");
                }

                double area = 0.5 * a * b;

                System.out.println("Results");
                System.out.println("Side a (Opposite): " + a);
                System.out.println("Side b (Adjacent): " + b);
                System.out.println("Side c (Hypotenuse): " + c);
                System.out.println("Angle A: " + angleA + " degrees");
                System.out.println("Angle B: " + angleB + " degrees");
                System.out.println("Area: " + area);
            }
        }
    /* critical questions
            1. Why must we validate that angles are less than 90°?
            Because all three angles in a triangle must add up to 180°. A right
            triangle already has a 90° angle, so the other two angles must share
            the remaining 90°. An angle of 90° or more would make this impossible.

            2. How does your program handle the different cases?
            The program uses menus and "if-else" statements. It first asks the user
            what they know (e.g., "two sides"). Based on their choice, it runs only
            the block of code that contains the correct formulas for that specific case.

            3. What would happen if a user entered values that don't form a valid right triangle?
            It would cause a math error. For example, if a leg is longer than the
            hypotenuse, the program would try to find the square root of a negative
            number, resulting in "NaN" (Not a Number). Input validation is used to
            prevent these errors and warn the user.
    */

    
    
        
        System.out.println("Problem 4: Trigonometric Identity Verifier");
        System.out.print("Enter an angle in degrees: ");
        double angleDegP4 = input.nextDouble();

        double angleRadP4 = Math.toRadians(angleDegP4);

        // Gamay ra ni nga value para sa atong 'allowance' kung mag-compare ta'g decimal
        double tolerance = 0.000001;

        // I-check nato: sin^2(θ) + cos^2(θ) = 1 
        System.out.println("Verifying: sin^2(θ) + cos^2(θ) = 1");
        double sinValP4 = Math.sin(angleRadP4);
        double cosValP4 = Math.cos(angleRadP4);
        
        double leftSide1 = (sinValP4 * sinValP4) + (cosValP4 * cosValP4);
        double rightSide1 = 1.0;

        // check kung ang difference nila kay gamay ra sa atong tolerance
        if (Math.abs(leftSide1 - rightSide1) < tolerance) {
            System.out.println("Result: The identity holds true.");
        } else {
            System.out.println("Result: The identity does NOT hold true.");
            System.out.println("Difference: " + Math.abs(leftSide1 - rightSide1));
        }

        // check nato: 1 + tan^2(θ) = sec^2(θ) 
        System.out.println("Verifying: 1 + tan^2(θ) = sec^2(θ)");
        
        // Check sa nato kung undefined ba ni nga angle (kung ang cos(θ) kay zero)
        if (Math.abs(cosValP4) < tolerance) {
            System.out.println("Result: Cannot verify. Tangent and Secant are undefined at this angle.");
        } else {
            double tanValP4 = Math.tan(angleRadP4);
            double secValP4 = 1 / cosValP4; // Ang secant kay 1/cos man
            
            double leftSide2 = 1 + (tanValP4 * tanValP4);
            double rightSide2 = secValP4 * secValP4;

            if (Math.abs(leftSide2 - rightSide2) < tolerance) {
                System.out.println("Result: The identity holds true.");
            } else {
                System.out.println("Result: The identity does NOT hold true.");
                System.out.println("Difference: " + Math.abs(leftSide2 - rightSide2));
            }
        

        // check nato: sin(2θ) = 2sin(θ)cos(θ) 
        System.out.println("Verifying: sin(2θ) = 2sin(θ)cos(θ)");
        double leftSide3 = Math.sin(2 * angleRadP4);
        double rightSide3 = 2 * sinValP4 * cosValP4;
        
        if (Math.abs(leftSide3 - rightSide3) < tolerance) {
            System.out.println("Result: The identity holds true.");
        } else {
            System.out.println("Result: The identity does NOT hold true.");
            System.out.println("Difference: " + Math.abs(leftSide3 - rightSide3));
        }
        
        /* critical questions
            1. Why do we need a tolerance when comparing floating-point values?
            Computers have tiny rounding errors with decimals (e.g., 0.9999999 instead
            of 1.0). A tolerance lets us check if two numbers are "close enough" to
            be considered equal.

            2. Which identity might be most susceptible to floating-point precision issues and why?
            The "1 + tan^2(θ) = sec^2(θ)" identity is most susceptible. Both tan() and
            sec() divide by cosine, and dividing by a near-zero number (when the angle
            is near 90°) can magnify small errors.

            3. How could you extend this program to verify more complex identities?
            You can simply add a new "if-else" block for each new identity you want to
            check. Inside the block, you calculate the left side and right side of
            the new formula and compare them like the others.
        */
        // Ibutang ni sa imong main method, kung asa pilion sa user ang Problem 5
        
        System.out.println("Problem 5: Wave Properties Analyzer");
        System.out.print("Enter the wave's Amplitude: ");
        double amplitudeP5 = input.nextDouble();
        System.out.print("Enter the wave's Frequency (in Hz): ");
        double frequencyP5 = input.nextDouble();
        System.out.print("Enter the Phase Shift (in degrees): ");
        double phaseShiftDegP5 = input.nextDouble();
        System.out.print("Enter a specific Time (t): ");
        double timeP5 = input.nextDouble();

        // --- I-check nato kung valid ba ang input ---
        if (amplitudeP5 <= 0 || frequencyP5 <= 0) {
            System.out.println("Error: Amplitude and Frequency must be positive numbers.");
            return; // Undanga ang program kung naay sayop
        }

        // --- Sugdan na nato ang mga Calculations ---
        double tol = 0.000001;
        // I-convert ang phase shift gikan sa degrees ngadto sa radians
        double phaseShiftRadP5 = Math.toRadians(phaseShiftDegP5);

        // 1. Kuhaon nato ang value sa wave anang time 't'
        double y_t = amplitudeP5 * Math.sin(2 * Math.PI * frequencyP5 * timeP5 + phaseShiftRadP5);
        System.out.println("Instantaneous value at time " + timeP5 + " is: " + y_t);

        // 2. Tan-awon nato kung peak, trough, o zero-crossing ba siya
        if (Math.abs(y_t - amplitudeP5) < tol) {
            System.out.println("At this time, the wave is at a PEAK.");
        } else if (Math.abs(y_t - (-amplitudeP5)) < tol) {
            System.out.println("At this time, the wave is at a TROUGH.");
        } else if (Math.abs(y_t) < tol) {
            System.out.println("At this time, the wave is at a ZERO-CROSSING.");
        } else {
            System.out.println("At this time, the wave is between points.");
        }

        // Pangitaon kung kanus-a ang sunod nga peak
        // Kuhaon ang Period (usa ka full cycle) sa wave
        double periodP5 = 1.0 / frequencyP5;
        // Pangitaon ang time sa pinaka-unang peak 
        double timeOfFirstPeak = ((Math.PI / 2.0) - phaseShiftRadP5) / (2 * Math.PI * frequencyP5);
        
        // tan-awon pila ka period ang nilabay gikan sa first peak hangtod sa atong time 't'
        double timeDiff = timeP5 - timeOfFirstPeak;
        double numPeriodsPassed = Math.floor(timeDiff / periodP5);
        
        // Ang sunod nga peak kay ang first peak plus (pila ka periods + 1)
        double nextPeakTime = timeOfFirstPeak + (numPeriodsPassed + 1) * periodP5;
        
        System.out.println("The next peak will occur at time: " + nextPeakTime);
    
        
        /* critical questions
            1. How did you determine if the wave is at a peak or trough?
            I calculated the wave's value at that time, y(t). The wave is at a PEAK
            if its value is equal to the positive amplitude (A), and at a TROUGH if
            it's equal to the negative amplitude (-A). A small tolerance was used for
            the comparison to handle decimal inaccuracies.

            2. What mathematical approach did you use to find the next peak?
            I used a period-based approach. First, I calculated the time of the very
            first peak. Then, I found how many full wave cycles (periods) had passed
            between that first peak and the user's given time. By adding one more
            full period, I could find the time of the very next peak.

            3. How would you modify this program to handle non-sinusoidal waves?
            The core formula for y(t) would have to be replaced with the one that
            describes the new wave (e.g., a square or sawtooth wave). The logic for
            finding peaks and troughs would also need a complete rewrite, as these
            are defined differently for other wave shapes.
*/
    
    
    }
    }
}
                
                
                
               

            
            
        
            
        
            
        
        





