package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagementSystem {
	private static final String url ="jdbc:mysql://localhost:3306/hospital";
	private static final String username ="root";
	private static final String password ="123456";
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){ 
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(System.in);
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			Patient patient = new Patient(connection, scanner);
			Doctor doctor = new Doctor(connection);
			
			while(true) {
				System.out.println("HOSPITAL MANAGEMENT SYSTEM");
				System.out.println("1. Add Patients");
				System.out.println("2. View Patients");
				System.out.println("3. View Doctors");
				System.out.println("4. Book Appointment");
				System.out.println("5. Exit");
				System.out.println("Enter Your Choice: ");
				int choice = scanner.nextInt();
				
				switch(choice) {
				case 1:
					patient.addPatient();
					break;
				case 2:
					patient.viewPatients();
					break;
				case 3:
					doctor.viewDoctors();
					break;
				case 4:
					bookAppointment(patient,doctor,connection,scanner );
					break;
				case 5:
					return;
				default:
					System.out.println("Enter Valid Choice!!!");
				}
				break;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void bookAppointment( Patient patient, Doctor doctor, Connection connection, Scanner scanner) {
		System.out.println("Enter patient id: ");
		int patientId = scanner.nextInt();
		System.out.println("Enter doctor id: ");
		int doctorId = scanner.nextInt();
		System.out.println("Enter Appointment date (YYYY.MM.DD)");
		String appointmentDate = scanner.next();	
		if(patient.getPatientById(patientId) && doctor.getPatientById(doctorId)) {
			if(checkDoctorAvailability(doctorId, appointmentDate, connection)) {
				String appointmentQuery = "Insert into appointments(patient_id, doctor_id, appointment_date) values(?,?,?)";
				try {
					PreparedStatement preparedStatement =connection.prepareStatement(appointmentQuery);
					preparedStatement.setInt(1, patientId);
					preparedStatement.setInt(2, doctorId);
					preparedStatement.setString(3, appointmentDate);
					int rowsAffected = preparedStatement.executeUpdate();
					if(rowsAffected>0) {
						System.out.println("Appointment Booked!!");
					}else {
						System.out.println("Failed to book Appointment!!!");
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("Doctor not available on this date!!!!");
			}
		}else {
			System.out.println("Either doctor or patient not available!!!");
		}
	}
	
	public static boolean checkDoctorAvailability(int doctorId, String appointmentDate, Connection connection) {
		String query ="select count(*) from appointments where doctor_id = ? and appointment_date = ?";
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, doctorId);
			preparedstatement.setString(2, appointmentDate);
			ResultSet resultSet = preparedstatement.executeQuery();
			if(resultSet.next()) {
				int count = resultSet.getInt(1);
				if (count == 0){
					return true;
				}else {
					return false;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
    }
