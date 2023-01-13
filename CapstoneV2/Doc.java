import java.util.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

class Doc {
   Scanner Scan = new Scanner(System.in);
   String Confirmed = "Confirmed.txt";
   String NonConfirmed = "Schedules.txt";

   void choice() throws rException {
      try {
         System.out.print("Select options below\n");
         System.out.print("[NList] see list of Non Confirmed\n");
         System.out.print("[Confirm] confirm a reservation\n");
         System.out.print("[Back] to return\n> ");
         String userInput = Scan.nextLine();

         if (userInput.equalsIgnoreCase("Nlist")) {
            NList();
         } else if (userInput.equalsIgnoreCase("Confirm")) {
            ConfirmRes();
         } else if (userInput.equalsIgnoreCase("Back")) {
            new MainCapstone();
         } else {
            System.out.print("Not in the choices!\n");
            choice();
         }

      } catch (Exception rException) {
         new rException();
      }
   }

   void Login() throws rException {
      try {
         System.out.print("You may type [Back] to return\n");
         System.out.print("Enter a Doctor Code:\n> ");
         String dInpt = Scan.nextLine();
         if (dInpt.equals("doc123")) {
            System.out.print("Login Success!\n");
            choice();
         } else if (dInpt.equalsIgnoreCase("Back")) {
            new MainCapstone();
         } else {
            System.out.print("Invalid Doctor Code!");
            Login();
         }
      } catch (Exception rException) {
         new rException();
      }
   }

   void ConfirmRes() throws rException {
      ArrayList<String> Patient = new ArrayList<>();
      try {
         System.out.print("Enter a patient username: \n> ");
         String p_inpt = Scan.nextLine();

         /* THIS SECTION LOOKS FOR EXISTING CONFIRMED USER RESERVATION */
         String SysReader = null;
         String p_inptCopy;

         Path Path_C = Paths.get(Confirmed.toString());
         InputStream SySinpt = Files.newInputStream(Path_C);
         BufferedReader B_Reader = new BufferedReader(new InputStreamReader(SySinpt));

         boolean found_Copy = false;

         while ((SysReader = B_Reader.readLine()) != null) {
            String User_Copy[] = SysReader.split(",");
            p_inptCopy = User_Copy[4];

            if (p_inptCopy.equals(p_inpt)) {
               System.out.print("This Application was Confirmed already\n");
               found_Copy = true;
            }
         }
         /* Start of Found Copy */
         switch (found_Copy + "-t") {
            case "false-t":
               Scanner LookFor = new Scanner(new File(NonConfirmed));
               LookFor.useDelimiter("\r?\r");

               while (LookFor.hasNext()) {
                  Patient.add(LookFor.next());
               }

               String NSysReader2 = null;
               String p_inptCopy2;

               Path path_C2 = Paths.get(NonConfirmed.toString());
               InputStream SySinpt2 = Files.newInputStream(path_C2);
               BufferedReader B_Reader2 = new BufferedReader(new InputStreamReader(SySinpt2));

               boolean found_Copy2 = false;

               while ((NSysReader2 = B_Reader2.readLine()) != null) {
                  String User_Copy2[] = NSysReader2.split(",");
                  p_inptCopy2 = User_Copy2[4];

                  if (p_inptCopy2.equals(p_inpt)) {
                     found_Copy2 = true;
                  }
               }

               /* Start of Found Copy2 */
               switch (found_Copy2 + "-s") {
                  case "true-s":
                     for (String Containters : Patient) {
                        if (Containters.contains(p_inpt)) {
                           String Lname, Fname, Email, Cont, User, Doctor, Speci, Date, Time;
                           String Finding[] = Containters.split(",");
                           Lname = Finding[0];
                           Fname = Finding[1];
                           Email = Finding[2];
                           Cont = Finding[3];
                           User = Finding[4];
                           Doctor = Finding[6];
                           Speci = Finding[7];
                           Date = Finding[8];
                           Time = Finding[9];

                           Path Path = Paths.get(Confirmed.toString());
                           OutputStream Output = new BufferedOutputStream(Files.newOutputStream(Path,
                                 APPEND));
                           BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(Output));

                           String LName = Lname;
                           String FName = Fname;
                           String E_Mail = Email;
                           String Ph_Num = Cont;

                           String Doc_Name = Doctor;
                           String Spefic = Speci;
                           String Dates = Date;
                           String Timee = Time;

                           Writer.write(LName + "," + FName + "," + E_Mail + "," + Ph_Num + "," + User + ","
                                 + Doc_Name + "," + Spefic + "," + Dates + "," + Timee);
                           Writer.newLine();
                           Writer.close();
                           Output.close();
                           System.out.print("Confirmed Reservation!\n");
                           choice();
                        }
                     }
               }
               /* End of Found Copy2 */

               break;
            case "true-t":
               choice();
               break;
            default:
         }

         /* End of Found Copy */
         System.out.print("User does not Exist!\n");
         choice();
      } catch (Exception rException) {
         new rException();
      }
   }

   void NList() throws rException {
      try {
         BufferedReader B_Reader;

         B_Reader = new BufferedReader(new FileReader(NonConfirmed));
         String list = B_Reader.readLine();
         System.out.print("Here is the list of the Non Apporved Schedules\n");
         while (list != null) {
            String Fname, Lname, Email, Cont, User, Doctor, Speci, Date, Time;
            String FN[] = list.split(",");
            String LN[] = list.split(",");
            String EM[] = list.split(",");
            String CN[] = list.split(",");
            String US[] = list.split(",");
            String DT[] = list.split(",");
            String SP[] = list.split(",");
            String DTT[] = list.split(",");
            String TM[] = list.split(",");

            Lname = LN[0];
            Fname = FN[1];
            Email = EM[2];
            Cont = CN[3];
            User = US[4];
            Doctor = DT[6];
            Speci = SP[7];
            Date = DTT[8];
            Time = TM[9];

            System.out.print("Last Name:        " + Lname.toUpperCase() + "\n");
            System.out.print("First Name:       " + Fname.toUpperCase() + "\n");
            System.out.print("Email:            " + Email + "\n");
            System.out.print("Contact Number:   " + Cont + "\n");
            System.out.print("Username:         " + User + "\n");
            System.out.print("Doctor:           " + Doctor.toUpperCase() + "\n");
            System.out.print("Specialization:   " + Speci.toUpperCase() + "\n");
            System.out.print("Date:             " + Date + "\n");
            System.out.print("Time:             " + Time + "\n\n");

            list = B_Reader.readLine();
         }
         B_Reader.close();
         choice();

      } catch (Exception rException) {
         new rException();
      }
   }
}
