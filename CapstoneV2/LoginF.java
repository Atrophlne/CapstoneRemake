import java.util.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

class LoginF {
   Scanner Scan = new Scanner(System.in);
   String Confirmed = "Confirmed.txt";
   String NonConfirmed = "Schedules.txt";

   void Login() throws rException {
      try {
         System.out.print("Enter Username: ");
         String username = Scan.nextLine();
         System.out.print("Enter Username: ");
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
               System.out.print("Login Success!\n\n");
               System.out.print("[NOTE] If nothing show's Means your Reservation is still not Accepted\n\n");
               found_Copy2 = true;
            }
         }

         switch (found_Copy2 + "-g") {
            case "true-g":
               String SysReader = null;
               Path Path_C = Paths.get(Confirmed.toString());
               InputStream SySinpt = Files.newInputStream(Path_C);
               BufferedReader B_Reader = new BufferedReader(new InputStreamReader(SySinpt));

               while ((SysReader = B_Reader.readLine()) != null) {
                  String LastName, FirstName, Email, Contact, Doctor, Specialization, Date, Time;

                  String LastNT[] = SysReader.split(",");
                  String FirstNT[] = SysReader.split(",");
                  String EmailNT[] = SysReader.split(",");
                  String ContactNT[] = SysReader.split(",");
                  String DoctorNT[] = SysReader.split(",");
                  String SpeciNT[] = SysReader.split(",");
                  String DateNT[] = SysReader.split(",");
                  String TimeNT[] = SysReader.split(",");

                  LastName = LastNT[0];
                  FirstName = FirstNT[1];
                  Email = EmailNT[2];
                  Contact = ContactNT[3];
                  Doctor = DoctorNT[5];
                  Specialization = SpeciNT[6];
                  Date = DateNT[7];
                  Time = TimeNT[8];

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
               break;
            default:
         }
         System.out.print("Cannot find Username\n\n");
         new MainCapstone();
      } catch (Exception rException) {
         new rException();
      }
   }
}
