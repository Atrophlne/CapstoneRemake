import java.util.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

class LoginF {
   Scanner Scan = new Scanner(System.in);
   String Confirmed = "Confirmed.txt";
   String NonConfirmed = "Schedules.txt";

   void Login() throws rException {
      ArrayList<String> Patient = new ArrayList<>();
      try {
         System.out.print("Enter Username: ");
         String username = Scan.nextLine();
         System.out.print("Enter Password: ");
         String password = Scan.nextLine();

         String NSysReader2 = null;
         String _UserName;
         String _PassWord;

         Path path_C2 = Paths.get(NonConfirmed.toString());
         InputStream SySinpt2 = Files.newInputStream(path_C2);
         BufferedReader B_Reader2 = new BufferedReader(new InputStreamReader(SySinpt2));
         boolean found_Copy2 = false;

         while ((NSysReader2 = B_Reader2.readLine()) != null) {
            String User_Copy2[] = NSysReader2.split(",");
            _UserName = User_Copy2[4];
            _PassWord = User_Copy2[5];

            if (_UserName.equals(username) && _PassWord.equals(password)) {
               found_Copy2 = true;
               System.out.print("\nLogin Success!\n\n");
               System.out.print("[NOTE] If nothing show's Means your Reservation is still not Accepted\n\n");
            }
         }

         switch (found_Copy2 + "-g") {
            case "true-g":
               Scanner LookFor = new Scanner(new File(Confirmed));
               LookFor.useDelimiter("\r?\r");

               while (LookFor.hasNext()) {
                  Patient.add(LookFor.next());
               }
               for (String Containters : Patient) {
                  if (Containters.contains(username)) {
                     String LastName, FirstName, Email, Contact, Doctor, Specialization, Date, Time;
                     String Finding[] = Containters.split(",");

                     LastName = Finding[0];
                     FirstName = Finding[1];
                     Email = Finding[2];
                     Contact = Finding[3];
                     Doctor = Finding[5];
                     Specialization = Finding[6];
                     Date = Finding[7];
                     Time = Finding[8];

                     System.out.print("Last Name:       " + LastName.toUpperCase() + "\n");
                     System.out.print("First Name:      " + FirstName.toUpperCase() + "\n");
                     System.out.print("Email Address:   " + Email + "\n");
                     System.out.print("Contact Nymber:  " + Contact + "\n");
                     System.out.print("Doctor:          " + Doctor.toUpperCase() + "\n");
                     System.out.print("Specialization:  " + Specialization.toUpperCase() + "\n");
                     System.out.print("Date:            " + Date + "\n");
                     System.out.print("Time:            " + Time + "\n\n");
                     new MainCapstone();
                  }
               }
               break;
            default:
               new MainCapstone();
         }
         System.out.print("Cannot find Username\n\n");
         new MainCapstone();
      } catch (Exception rException) {
         new rException();
      }
   }
}
