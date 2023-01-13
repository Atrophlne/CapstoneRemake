import java.util.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class MainCapstone {
   public MainCapstone() throws IOException, rException {
      Scanner Scan = new Scanner(System.in);
      System.out.print(">> [Login] to see your full details.\n");
      System.out.print(">> [Create] to see your create a new appointment.\n");
      System.out.print(">> [List] to see The List of the Doctors, Specialization.\n");
      System.out.print(">> [Doc] to log as a Doctor.\n>> ");
      String userInput = Scan.nextLine();

      if (userInput.equalsIgnoreCase("Login")) {
         LoginF L_F = new LoginF();
         L_F.Login();
      } else if (userInput.equalsIgnoreCase("Create")) {
         CreateForm CF = new CreateForm();
         CF.SelectSpeci();
      } else if (userInput.equalsIgnoreCase("List")) {

         System.out.print("List of the Doctors and their Specification\n\n");

         System.out.print("Specialization: Neurologist \n");
         System.out.print("Doctor Name: " + "Dr. Stephen Cromwell "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + "\t\t\n");
         System.out.print("Doctor Name: " + "Dr. Jeffrey Monrow "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Charles West "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Paul Adler "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Elisabeth Ford "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n\n");

         System.out.print("Specialization: Cardiologist \n");
         System.out.print("Doctor Name: " + "Dr. Thomas Dawson "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Joseph Grey "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Richard Anderson "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Wiilliam Carter "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Robert Lenon "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n\n");

         System.out.print("Specialization: Pulmonologist  \n");
         System.out.print("Doctor Name: " + "Dr. John Astor "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Michael Clifford "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. David Forbes "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Jenifer Hoffman "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Mark Johnson "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n\n");

         System.out.print("Specialization: Gynecologist \n");
         System.out.print("Doctor Name: " + "Dr. Paula Lauren "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Kristine Lopez "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Rosie Morgan "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Samantha Ortega "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Suzanne Smith "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n\n");

         System.out.print("Specialization: Gastroentorologist \n");
         System.out.print("Doctor Name: " + "Dr. George Presley "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Eugene Raynolds "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Alan Thomson "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Christhoper Welch "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Klaine Ferrer "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n\n");

         System.out.print("Specialization: Optalmologist \n");
         System.out.print("Doctor Name: " + "Dr. Claire Velasco "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Taylor Fuentez "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Kim Caniete "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Cythia Samson "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Jonathan Fajardo "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n\n");

         System.out.print("Specialization: Otolaryngologist \n");
         System.out.print("Doctor Name: " + "Dr. Ralph Mallari "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Matthew Gregorio "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Steven Chua "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Cristina Sevilia "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Emily Ybaniez "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n\n");

         System.out.print("Specialization: Orthopedic \n");
         System.out.print("Doctor Name: " + "Dr. Vincent Ventura "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Kenneth Herrera "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Nathan Baltazar "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Daniel Cervantes "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Dianne Arevalo "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n\n");

         System.out.print("Specialization: Urologists \n");
         System.out.print("Doctor Name: " + "Dr. Andrew Ronquillo "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Manuel Mendenz "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Ronald Gomez "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Roan Velasquez "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Scott Williams "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n\n");

         System.out.print("Specialization: Hematologist \n");
         System.out.print("Doctor Name: " + "Dr. Timothy Evangelista "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Tristan Mariano "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Harold De Vera "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Caroline Velncia "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Claudia Cabrera "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n\n");

         System.out.print("Specialization: Pediatrician \n");
         System.out.print("Doctor Name: " + "Dr. Catherine Espinosa "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Miranda Serrano "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Sebastian Medina "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + "  \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Juliette Acosta "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + " \t\t\n");
         System.out.print("Doctor Name: " + "Dr. Kelly Bernardo "
               + "Available Time: [<Time1>, <Time2>, <Time3>, <Time4>, <Time5>] " + "\t\t\n\n");
         new MainCapstone();

      } else if (userInput.equalsIgnoreCase("Doc")) {
         Doc Dc = new Doc();
         Dc.Login();
      } else {
         System.out.print("Cannot find this in the Choices\n");
         new MainCapstone();
      }

   }

   public static void main(String[] args) throws IOException, rException {
      new MainCapstone();
   }
}

class rException extends Exception {
   public rException() {
      super("Error has occured");
   }
}