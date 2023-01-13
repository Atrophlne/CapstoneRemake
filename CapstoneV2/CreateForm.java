import java.util.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

class CreateForm extends CreateEncapsulation {
    Scanner Scan = new Scanner(System.in);
    String RegisterFile = "Schedules.txt";

    void C_Form() {
        try {

            String _reader = null;
            String _ExistingEmail;
            String _ExistingUsername;

            Path _Paths = Paths.get(RegisterFile.toString());
            InputStream _RegForms = Files.newInputStream(_Paths);
            BufferedReader _reader2 = new BufferedReader(new InputStreamReader(_RegForms));

            System.out.print("\nNow using Registration\n");

            System.out.print("Enter Your Last Name: \n>> ");
            String LastName = Scan.nextLine();
            System.out.print("Enter Your First Name: \n>> ");
            String FirstName = Scan.nextLine();
            System.out.print("Enter Your Phone Number: \n>> ");
            String PhoneNumber = Scan.nextLine();
            System.out.print("Enter Your Email: \n>> ");
            String EmailAdd = Scan.nextLine();
            System.out.print("Enter Your User Name: \n>> ");
            String UserName = Scan.nextLine();
            System.out.print("Enter Your Password: \n>> ");
            String Password = Scan.nextLine();

            boolean RegisteredEmail = false;
            boolean RegisteredUsername = false;

            /*
             * While loop is used to check the txt file if there is already an email or
             * password existing to the database
             */

            while ((_reader = _reader2.readLine()) != null) {
                String _email[] = _reader.split(",");
                String _username[] = _reader.split(",");
                _ExistingEmail = _email[2];
                _ExistingUsername = _username[4];

                if (_ExistingEmail.equals(EmailAdd)) {
                    RegisteredEmail = true;
                }

                if (_ExistingUsername.equals(UserName)) {
                    RegisteredUsername = true;
                }
            }

            switch (RegisteredEmail + " - " + RegisteredUsername) {
                /* If the Email is already Registered */
                case "true - false":
                    Poly2 p2 = new Poly2();
                    p2.Ms_1();
                    C_Form();
                    break;
                /* If the Username is already Registered */
                case "false - true":
                    Poly3 p3 = new Poly3();
                    p3.Ms_1();
                    C_Form();
                    break;
                /* If both is already Registered */
                case "true - true":
                    Poly4 p4 = new Poly4();
                    p4.Ms_1();
                    C_Form();
                    break;
            }
            if (RegisteredEmail != true && RegisteredUsername != true) {
                setFirstName(FirstName);
                setLastName(LastName);
                setEmailId(EmailAdd);
                setPhoneNo(PhoneNumber);
                setUserName(UserName);
                setPassword(Password);
                Confirmation();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Confirmation */

    void Confirmation() {
        try {

            System.out.print("Last Name: " + getLastName() + "\n");
            System.out.print("First Name: " + getFirstName() + "\n");
            System.out.print("Email: " + getEmailId() + "\n");
            System.out.print("Phone Number: " + getPhoneNo() + "\n");
            System.out.print("User Name: " + getUserName() + "\n");
            System.out.print("Doctor Name: " + getDoctor() + "\n");
            System.out.print("Specialization " + getSpecif() + "\n");
            System.out.print("Date: " + getDate() + "\n");
            System.out.print("Time: " + getTime() + "\n");

            System.out.print("Confirm Reservation? [Y] or [N]\n> ");
            String inpt = Scan.nextLine();

            if (inpt.equalsIgnoreCase("Y")) {

                Path Path = Paths.get(RegisterFile.toString());
                OutputStream Output = new BufferedOutputStream(Files.newOutputStream(Path, APPEND));
                BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(Output));

                String LName = getLastName();
                String FName = getFirstName();
                String E_Mail = getEmailId();
                String Ph_Num = getPhoneNo();
                String User_Name = getUserName();
                String Pass_Word = getPassword();
                String Doc_Name = getDoctor();
                String Spefic = getSpecif();
                String Date = getDate();
                String Time = getTime();

                Writer.write(LName + "," + FName + "," + E_Mail + "," + Ph_Num + "," + User_Name + "," + Pass_Word + ","
                        + Doc_Name + "," + Spefic + "," + Date + "," + Time);
                Writer.newLine();
                Writer.close();
                Output.close();

                System.out.print(
                        "Form Submitted for Reservation \nEnter your User and Password to see if it is confirmed\n");
                new MainCapstone();
            } else if (inpt.equalsIgnoreCase("N")) {
                SelectSpeci();
            } else {
                System.out.print("The Choice selected is invalid\n");
                Confirmation();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Select Specialization */

    void SelectSpeci() {
        try {
            System.out.print("You may type [Back] to return\n");
            System.out.print("Enter the Doctor's Specialization: ");
            String Specialization = Scan.nextLine();

            if (Specialization.equalsIgnoreCase("Neurologist")) {
                setSpecif(Specialization);
                Neurologist();
            } else if (Specialization.equalsIgnoreCase("Cardiologist")) {
                setSpecif(Specialization);
                Cardiologist();
            } else if (Specialization.equalsIgnoreCase("Pulmonologist")) {
                setSpecif(Specialization);
                Pulmonologist();
            } else if (Specialization.equalsIgnoreCase("Gynecologist")) {
                setSpecif(Specialization);
                Gynecologist();
            } else if (Specialization.equalsIgnoreCase("Gastroentorologist")) {
                setSpecif(Specialization);
                Gastroentorologist();
            } else if (Specialization.equalsIgnoreCase("Optalmologist")) {
                setSpecif(Specialization);
                Optalmologist();
            } else if (Specialization.equalsIgnoreCase("Otolaryngologist")) {
                setSpecif(Specialization);
                Otolaryngologist();
            } else if (Specialization.equalsIgnoreCase("Orthopedic")) {
                setSpecif(Specialization);
                Orthopedic();
            } else if (Specialization.equalsIgnoreCase("Urologists")) {
                setSpecif(Specialization);
                Urologists();
            } else if (Specialization.equalsIgnoreCase("Hematologist")) {
                setSpecif(Specialization);
                Hematologist();
            } else if (Specialization.equalsIgnoreCase("Pediatrician")) {
                setSpecif(Specialization);
                Pediatrician();
            } else if (Specialization.equalsIgnoreCase("Back")) {
                System.out.print("Going back!\n");
                new MainCapstone();
            } else {
                System.out.print("The Specialization seems to be not in the list!\n");
                SelectSpeci();
            }
            setSpecif(Specialization);

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Neurologist */

    void Neurologist() {
        try {
            System.out.print("Only put the Dr's Name\n");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Neurologist: \n> Dr. ");
            String Doctor = Scan.nextLine();
            if (Doctor.equalsIgnoreCase("Stephen Cromwell")) {
                System.out.print("You have Chosen Dr. Stephen Cromwell\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();
            } else if (Doctor.equalsIgnoreCase("Jeffrey Monrow")) {
                System.out.print("You have Chosen Dr. Jeffrey Monrow\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Charles West")) {
                System.out.print("You have Chosen Dr. Charles West\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Paul Adler")) {
                System.out.print("You have Chosen Dr. Paul Adler\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Elisabeth Ford")) {
                System.out.print("You have Chosen Dr. Elisabeth Ford\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Neurologist();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Cardiologist */

    void Cardiologist() {
        try {

            System.out.print("Only put the Dr's Name");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Cardiologist: \n> Dr. ");
            String Doctor = Scan.nextLine();
            if (Doctor.equalsIgnoreCase("Thomas Dawson")) {
                System.out.print("You have Chosen Dr. Thomas Dawson\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Joseph Grey")) {
                System.out.print("You have Chosen Dr. Joseph Grey\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Richard Anderson")) {
                System.out.print("You have Chosen Dr. Richard Anderson\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Wiilliam Carter")) {
                System.out.print("You have Chosen Dr. Wiilliam Carter\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Robert Lenon")) {
                System.out.print("You have Chosen Dr. Robert Lenon\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Cardiologist();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Pulmonologist */

    void Pulmonologist() {
        try {

            System.out.print("Only put the Dr's Name");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Pulmonologist: \n> Dr. ");
            String Doctor = Scan.nextLine();

            if (Doctor.equalsIgnoreCase("John Astor")) {
                System.out.print("You have Chosen Dr. John Astor\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Michael Clifford")) {
                System.out.print("You have Chosen Dr. Michael Clifford\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("David Forbes")) {
                System.out.print("You have Chosen Dr. David Forbes\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Jenifer Hoffman")) {
                System.out.print("You have Chosen Dr. Jenifer Hoffman\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Mark Johnson")) {
                System.out.print("You have Chosen Dr. Mark Johnson\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Pulmonologist();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Gynecologist */

    void Gynecologist() {
        try {

            System.out.print("Only put the Dr's Name");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Gynecologist: \n> Dr. ");
            String Doctor = Scan.nextLine();
            setDoctor(Doctor);
            if (Doctor.equalsIgnoreCase("Paula Lauren")) {
                System.out.print("You have Chosen Dr. Paula Lauren\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Kristine Lopez")) {
                System.out.print("You have Chosen Dr. Kristine Lopez\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Rosie Morgan ")) {
                System.out.print("You have Chosen Dr. Rosie Morgan \n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Samantha Ortega")) {
                System.out.print("You have Chosen Dr. Samantha Ortega\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Suzanne Smith")) {
                System.out.print("You have Chosen Dr. Suzanne Smith\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Gynecologist();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Gastroentorologist */

    void Gastroentorologist() {
        try {

            System.out.print("Only put the Dr's Name");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Gastroentorologist: \n> Dr. ");
            String Doctor = Scan.nextLine();
            setDoctor(Doctor);
            if (Doctor.equalsIgnoreCase("George Presley")) {
                System.out.print("You have Chosen Dr. George Presley\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Eugene Raynolds")) {
                System.out.print("You have Chosen Dr. Eugene Raynolds\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Alan Thomson")) {
                System.out.print("You have Chosen Dr. Alan Thomson\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Christhoper Welch")) {
                System.out.print("You have Chosen Dr. Christhoper Welch\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Klaine Ferrer")) {
                System.out.print("You have Chosen Dr. Klaine Ferrer\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Gastroentorologist();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Optalmologist */

    void Optalmologist() {
        try {

            System.out.print("Only put the Dr's Name");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Optalmologist: \n> Dr. ");
            String Doctor = Scan.nextLine();
            setDoctor(Doctor);
            if (Doctor.equalsIgnoreCase("Claire Velasco")) {
                System.out.print("You have Chosen Dr. Claire Velasco\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Taylor Fuentez")) {
                System.out.print("You have Chosen Dr. Taylor Fuentez\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Kim Caniete")) {
                System.out.print("You have Chosen Dr. Kim Caniete\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Cythia Samson")) {
                System.out.print("You have Chosen Dr. Cythia Samson\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Jonathan Fajardo")) {
                System.out.print("You have Chosen Dr. Jonathan Fajardo\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Optalmologist();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Otolaryngologist */

    void Otolaryngologist() {
        try {

            System.out.print("Only put the Dr's Name");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Otolaryngologist: \n> Dr. ");
            String Doctor = Scan.nextLine();
            setDoctor(Doctor);
            if (Doctor.equalsIgnoreCase("Ralph Mallari")) {
                System.out.print("You have Chosen Dr. Ralph Mallari\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Matthew Gregorio")) {
                System.out.print("You have Chosen Dr. Matthew Gregorio\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Steven Chua")) {
                System.out.print("You have Chosen Dr. Steven Chua\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Cristina Sevilia")) {
                System.out.print("You have Chosen Dr. Cristina Sevilia\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Emily Ybaniez")) {
                System.out.print("You have Chosen Dr. Emily Ybaniez\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Otolaryngologist();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Orthopedic */

    void Orthopedic() {
        try {

            System.out.print("Only put the Dr's Name");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Orthopedic: \n> Dr. ");
            String Doctor = Scan.nextLine();
            setDoctor(Doctor);
            if (Doctor.equalsIgnoreCase("Vincent Ventura")) {
                System.out.print("You have Chosen Dr. Vincent Ventura\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Kenneth Herrera")) {
                System.out.print("You have Chosen Dr. Kenneth Herrera\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Nathan Baltazar")) {
                System.out.print("You have Chosen Dr. Nathan Baltazar\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Daniel Cervantes")) {
                System.out.print("You have Chosen Dr. Daniel Cervantes\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Dianne Arevalo")) {
                System.out.print("You have Chosen Dr. Dianne Arevalo\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Orthopedic();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Urologist */

    void Urologists() {
        try {

            System.out.print("Only put the Dr's Name");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Urologists: \n> Dr. ");
            String Doctor = Scan.nextLine();
            setDoctor(Doctor);
            if (Doctor.equalsIgnoreCase("Andrew Ronquillo")) {
                System.out.print("You have Chosen Dr. Andrew Ronquillo\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Manuel Mendenz")) {
                System.out.print("You have Chosen Dr. Manuel Mendenz\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Ronald Gomez")) {
                System.out.print("You have Chosen Dr. Ronald Gomez\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Roan Velasquez")) {
                System.out.print("You have Chosen Dr. Roan Velasquez\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Scott Williams")) {
                System.out.print("You have Chosen Dr. Scott Williams\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Urologists();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Hematologist */

    void Hematologist() {
        try {

            System.out.print("Only put the Dr's Name");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Hematologist: \n> Dr. ");
            String Doctor = Scan.nextLine();
            setDoctor(Doctor);
            if (Doctor.equalsIgnoreCase("Timothy Evangelista")) {
                System.out.print("You have Chosen Dr. Timothy Evangelista\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Tristan Mariano")) {
                System.out.print("You have Chosen Dr. Tristan Mariano\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Harold De Vera")) {
                System.out.print("You have Chosen Dr. Harold De Vera\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Caroline Velncia")) {
                System.out.print("You have Chosen Dr. Caroline Velncia\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Claudia Cabrera")) {
                System.out.print("You have Chosen Dr. Claudia Cabrera\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Hematologist();
            }

        } catch (Exception rException) {
            new rException();
        }
    }

    /* Pediatrician */

    void Pediatrician() {
        try {

            System.out.print("Only put the Dr's Name");
            System.out.print("You may type [Back] if you've chosen the wrong Specialization\n");
            System.out.print("Now Select a Doctor in Pediatrician: \n> Dr. ");
            String Doctor = Scan.nextLine();
            setDoctor(Doctor);
            if (Doctor.equalsIgnoreCase("Catherine Espinosa")) {
                System.out.print("You have Chosen Dr. Catherine Espinosa\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Miranda Serrano")) {
                System.out.print("You have Chosen Dr. Miranda Serrano\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Sebastian Medina")) {
                System.out.print("You have Chosen Dr. Sebastian Medina\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Juliette Acosta")) {
                System.out.print("You have Chosen Dr. Juliette Acosta\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Kelly Bernardo")) {
                System.out.print("You have Chosen Dr. Kelly Bernardo\n");
                System.out.print("Enter the Schedule Date in this format [MM-DD-YYYY]\n> ");
                String Date = Scan.nextLine();
                System.out.print("Enter the Schedule Time in this format [10:00am]\n> ");
                String Time = Scan.nextLine();
                setDoctor(Doctor);
                setDate(Date);
                setTime(Time);
                C_Form();

            } else if (Doctor.equalsIgnoreCase("Back")) {
                System.out.print("Going Back!\n");

            } else {
                System.out.print("The Doctor's Name seems to be not in the list");
                Pediatrician();
            }

        } catch (Exception rException) {
            new rException();
        }
    }
}
